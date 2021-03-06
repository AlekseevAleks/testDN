package ru.lexxdroid.testdn.domain.schedule

import io.reactivex.Scheduler

interface Schedulers {

    fun io(): Scheduler

    fun computation(): Scheduler

    fun main(): Scheduler
}