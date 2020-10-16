package ru.lexxdroid.testdn.domain.splash

import dagger.Binds
import dagger.Module

@Module
interface SplashModule {

    @Binds
    fun bindSplashInteractor(splashModel: SplashModel): SplashInteractor
}