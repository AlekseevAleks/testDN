package ru.lexxdroid.testdn.presentation.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
internal interface AppComponent : AndroidInjector<App>