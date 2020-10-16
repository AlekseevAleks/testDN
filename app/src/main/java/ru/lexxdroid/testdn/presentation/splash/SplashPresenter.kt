package ru.lexxdroid.testdn.presentation.splash

import io.reactivex.Single
import ru.lexxdroid.testdn.domain.schedule.Schedulers
import ru.lexxdroid.testdn.domain.splash.SplashInteractor
import ru.lexxdroid.testdn.domain.splash.SplashState
import ru.lexxdroid.testdn.presentation.core.BasePresenter
import ru.lexxdroid.testdn.presentation.error.ErrorUtils
import ru.lexxdroid.testdn.presentation.navigation.RouterMediator
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val SPLASH_TIME_SECONDS = 2L

class SplashPresenter
@Inject constructor(
    router: RouterMediator,
    interactor: SplashInteractor,
    schedulers: Schedulers
) : BasePresenter<SplashState, SplashView, SplashInteractor>(
    router, interactor, schedulers
) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposeOnDestroy(
            startTimer()
                .observeOn(schedulers.main())
                .subscribe(
                    { router.navigateToNewsList() },
                    { ErrorUtils::onError }
                )
        )
    }

    private fun startTimer() = Single.timer(SPLASH_TIME_SECONDS, TimeUnit.SECONDS, schedulers.io())
}