package ru.lexxdroid.testdn.presentation.core

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import ru.lexxdroid.testdn.presentation.extensions.baseMoxyPresenter
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseFragment<S, SP : Parcelable, P : BasePresenter<S, *, *>>
@ContentView constructor(@LayoutRes contentLayoutId: Int) : MvpAppCompatFragment(contentLayoutId),
    BaseView<S>,
    HasAndroidInjector {

    companion object {
        private const val BUNDLE_SAVED_STATE = "BUNDLE_SAVED_STATE"
    }

    private var state: S? = null
    private var savedState: SP? = null


    protected open val stateMappers: StateMappers<S, SP>? = null

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var presenterProvider: Provider<P>

    protected val presenter by baseMoxyPresenter(::presenterProvider::class.java.name) { presenterProvider.get() }

    protected val appCompatActivity: AppCompatActivity
        get() = (requireActivity() as? AppCompatActivity)
            ?: throw ClassCastException("Only AppCompat activities are supported")


    protected open val isNavigationBackVisible: Boolean
        get() {
            return parentFragmentManager.backStackEntryCount > 0 ||
                    (activity as AppCompatActivity).supportFragmentManager.backStackEntryCount > 0
        }

    override fun androidInjector() = dispatchingAndroidInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedState = savedInstanceState?.getParcelable(BUNDLE_SAVED_STATE)
        savedState
            ?.let { stateMappers?.run { toState(it) } }
            ?.also(presenter::restoreState)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        with(toolbarDelegate) {
//            bindToActivity(appCompatActivity, ::isNavigationBackVisible)
//            toolbar?.let { view.addSystemInsetPadding(it) }
//        }
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val parcelable = state?.let { stateMappers?.run { toParcelable(it) } }
            ?: savedState
        parcelable?.also { outState.putParcelable(BUNDLE_SAVED_STATE, it) }
    }

    override fun onDestroyView() {
//        toolbarDelegate.unbind()
        super.onDestroyView()
    }

    @CallSuper
    override fun setState(state: S) {
        this.state = state
    }
}

data class StateMappers<S, SP : Parcelable>(
    val toParcelable: (S) -> SP,
    val toState: (SP) -> S
)