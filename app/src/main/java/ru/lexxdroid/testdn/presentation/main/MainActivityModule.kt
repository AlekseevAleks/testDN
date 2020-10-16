package ru.lexxdroid.testdn.presentation.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.lexxdroid.testdn.domain.main.MainModule
import ru.lexxdroid.testdn.presentation.navigation.NavigatorImpl
import ru.terrakok.cicerone.Navigator

@Module
interface MainActivityModule {

    companion object {
        @Provides
        fun provideContainerId(): ContainerIdProvider = MainActivity
    }

    @Binds
    fun bindNavigator(navigator: NavigatorImpl): Navigator
}