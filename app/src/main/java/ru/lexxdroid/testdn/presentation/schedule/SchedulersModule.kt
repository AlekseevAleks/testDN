package ru.lexxdroid.testdn.presentation.schedule

import dagger.Binds
import dagger.Module
import ru.lexxdroid.testdn.domain.schedule.Schedulers

@Module
interface SchedulersModule {

    @Binds
    fun bindSchedulers(schedulers: SchedulersImpl): Schedulers
}