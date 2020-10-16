package ru.lexxdroid.testdn.presentation.splash

import ru.lexxdroid.testdn.R
import ru.lexxdroid.testdn.domain.splash.SplashState
import ru.lexxdroid.testdn.presentation.core.BaseFragment

class SplashFragment :
    BaseFragment<SplashState, SplashStateParcelable, SplashPresenter>(R.layout.fragment_splash),
    SplashView