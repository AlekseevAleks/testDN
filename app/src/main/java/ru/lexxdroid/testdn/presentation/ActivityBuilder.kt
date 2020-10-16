package ru.lexxdroid.testdn.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.lexxdroid.testdn.presentation.main.MainActivity
import ru.lexxdroid.testdn.presentation.main.MainActivityModule

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            FragmentBuilder::class
        ]
    )
    fun mainActivityInjector(): MainActivity
}