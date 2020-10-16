package ru.lexxdroid.testdn.presentation.extensions

import moxy.MvpDelegateHolder
import moxy.MvpPresenter
import moxy.ktx.MoxyKtxDelegate

fun <T : MvpPresenter<*>> MvpDelegateHolder.baseMoxyPresenter(
    name: String,
    factory: () -> T
): MoxyKtxDelegate<T> {
    return MoxyKtxDelegate(mvpDelegate, name, factory)
}