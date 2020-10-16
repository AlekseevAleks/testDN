package ru.lexxdroid.testdn.presentation.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.lexxdroid.testdn.presentation.PresentationModule

@Module(
    includes = [
        PresentationModule::class
    ]
)
abstract class ApplicationModule {

    companion object {
        @Provides
        fun providesContext(application: App): Context = application
    }
}