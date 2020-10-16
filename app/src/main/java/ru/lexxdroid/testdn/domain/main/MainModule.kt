package ru.lexxdroid.testdn.domain.main

import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun bindMainInteractor(mainModel: MainModel): MainInteractor
}