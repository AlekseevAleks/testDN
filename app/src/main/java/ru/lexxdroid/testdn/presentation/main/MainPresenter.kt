package ru.lexxdroid.testdn.presentation.main

import ru.lexxdroid.testdn.domain.main.MainInteractor
import ru.lexxdroid.testdn.domain.main.MainState
import ru.lexxdroid.testdn.domain.schedule.Schedulers
import ru.lexxdroid.testdn.presentation.core.BasePresenter
import ru.lexxdroid.testdn.presentation.navigation.RouterMediator
import javax.inject.Inject

class MainPresenter
@Inject constructor(
    router: RouterMediator,
    interactor: MainInteractor,
    schedulers: Schedulers
) : BasePresenter<MainState, MainView, MainInteractor>(router, interactor, schedulers) {

    var isFreshStart: Boolean = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (isFreshStart) {
            router.navigateToSplash()
        }
    }
}