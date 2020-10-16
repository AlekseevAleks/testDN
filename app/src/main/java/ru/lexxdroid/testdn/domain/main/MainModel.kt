package ru.lexxdroid.testdn.domain.main

import ru.lexxdroid.testdn.domain.core.BaseModel
import javax.inject.Inject

class MainModel @Inject constructor() : BaseModel<MainState>(MainState), MainInteractor