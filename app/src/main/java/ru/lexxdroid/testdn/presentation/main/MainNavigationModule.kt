package ru.lexxdroid.testdn.presentation.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.lexxdroid.testdn.presentation.navigation.RouterMediator
import ru.lexxdroid.testdn.presentation.navigation.RouterMediatorImpl
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
interface MainNavigationModule {

    companion object {
        @Singleton
        @Provides
        fun provideRouter() = Router()

        @Singleton
        @Provides
        fun provideNavigationHolder(router: Router) =
            Cicerone.create(router).navigatorHolder
    }

    @Singleton
    @Binds
    fun bindRouterMediator(routerMediatorImpl: RouterMediatorImpl): RouterMediator
}