package ru.lexxdroid.testdn.presentation.core

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


interface BaseView<T> : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setState(state: T)
}