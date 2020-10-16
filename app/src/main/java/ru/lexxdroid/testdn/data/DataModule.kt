package ru.lexxdroid.testdn.data

import dagger.Binds
import dagger.Module
import ru.lexxdroid.testdn.data.network.NetworkModule
import ru.lexxdroid.testdn.data.network.NewsDataSource
import ru.lexxdroid.testdn.data.network.NewsSource
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class
    ]
)
interface DataModule {

    @Binds
    @Singleton
    fun provideNewsSource(newsDataSource: NewsDataSource) : NewsSource
}