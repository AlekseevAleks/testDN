package ru.lexxdroid.testdn.presentation.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideApp() = app
}
