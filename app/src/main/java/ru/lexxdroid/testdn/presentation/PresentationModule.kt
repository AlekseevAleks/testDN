package ru.lexxdroid.testdn.presentation

import dagger.Module
import ru.lexxdroid.testdn.domain.DomainModule
import ru.lexxdroid.testdn.presentation.main.MainNavigationModule
import ru.lexxdroid.testdn.presentation.schedule.SchedulersModule

@Module(
    includes = [
        DomainModule::class,
        ActivityBuilder::class,
        MainNavigationModule::class,
        SchedulersModule::class
    ]
)
interface PresentationModule {
}