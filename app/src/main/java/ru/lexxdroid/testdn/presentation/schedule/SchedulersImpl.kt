package ru.lexxdroid.testdn.presentation.schedule

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lexxdroid.testdn.domain.schedule.Schedulers
import javax.inject.Inject

class SchedulersImpl @Inject constructor() : Schedulers {

    override fun io(): Scheduler = io.reactivex.schedulers.Schedulers.io()

    override fun computation(): Scheduler = io.reactivex.schedulers.Schedulers.computation()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}