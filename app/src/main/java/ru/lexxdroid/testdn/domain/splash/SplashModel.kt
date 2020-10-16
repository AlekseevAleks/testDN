package ru.lexxdroid.testdn.domain.splash

import ru.lexxdroid.testdn.domain.core.BaseModel
import javax.inject.Inject

class SplashModel
@Inject constructor() : BaseModel<SplashState>(SplashState), SplashInteractor