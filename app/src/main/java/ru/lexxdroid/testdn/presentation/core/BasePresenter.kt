package ru.lexxdroid.testdn.presentation.core

import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.lexxdroid.testdn.domain.core.Interactor
import ru.lexxdroid.testdn.domain.schedule.Schedulers
import ru.lexxdroid.testdn.presentation.error.ErrorUtils
import ru.lexxdroid.testdn.presentation.navigation.RouterMediator

abstract class BasePresenter<S, V : BaseView<S>, I : Interactor<S>>(
    protected val router: RouterMediator,
    protected val interactor: I,
    protected val schedulers: Schedulers
) : MvpPresenter<V>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposeOnDestroy(
            interactor.observeState()
                .observeOn(schedulers.main())
                .subscribe(
                    viewState::setState,
                    ErrorUtils::onError
                )
        )
    }

    @CallSuper
    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    protected fun disposeOnDestroy(vararg disposables: Disposable) {
        disposables.forEach(compositeDisposable::plusAssign)
    }

    protected fun Disposable.disposeNow() {
        takeIf { !it.isDisposed }?.dispose()
    }

    fun restoreState(state: S) {
        interactor.restoreState(state)
    }
}
