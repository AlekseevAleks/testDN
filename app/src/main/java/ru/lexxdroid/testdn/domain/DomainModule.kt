package ru.lexxdroid.testdn.domain

import dagger.Module
import ru.lexxdroid.testdn.data.DataModule
import ru.lexxdroid.testdn.domain.main.MainModule
import ru.lexxdroid.testdn.domain.newslist.NewsListModule
import ru.lexxdroid.testdn.domain.splash.SplashModule

@Module(
    includes = [
        DataModule::class,
        SplashModule::class,
        MainModule::class,
        NewsListModule::class
    ]
)
interface DomainModule