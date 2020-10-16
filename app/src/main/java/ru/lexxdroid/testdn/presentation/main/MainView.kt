package ru.lexxdroid.testdn.presentation.main

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.lexxdroid.testdn.domain.main.MainState
import ru.lexxdroid.testdn.presentation.core.BaseView

interface MainView : BaseView<MainState> {

    @StateStrategyType(AddToEndSingleStrategy::class)
    override fun setState(state: MainState) {
        // no op
    }
}