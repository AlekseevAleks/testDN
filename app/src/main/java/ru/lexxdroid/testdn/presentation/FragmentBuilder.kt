package ru.lexxdroid.testdn.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.lexxdroid.testdn.presentation.newslist.NewsListFragment
import ru.lexxdroid.testdn.presentation.splash.SplashFragment

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector
    fun splashFragmentInjector(): SplashFragment

    @ContributesAndroidInjector
    fun newsListFragmentInjector(): NewsListFragment
}