package ru.lexxdroid.testdn.domain.core

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

abstract class BaseModel<T>(defaultState: T) : Interactor<T> {

    private var startState: T = defaultState

    private val stateSubject: Subject<T> by lazy {
        BehaviorSubject.createDefault(startState).toSerialized()
    }

    override fun observeState(): Observable<T> = stateSubject.hide()

    override fun restoreState(state: T) {
        startState = state
    }

    protected fun getState(): T = stateSubject.blockingFirst()

    protected fun updateState(state: T) {
        stateSubject.onNext(state)
    }

    protected inline fun updateState(updater: T.() -> T) {
        updateState(updater(getState()))
    }
}