package ru.lexxdroid.testdn.domain.core

import io.reactivex.Observable

interface Interactor<T> {

    fun observeState(): Observable<T>

    fun restoreState(state: T)
}