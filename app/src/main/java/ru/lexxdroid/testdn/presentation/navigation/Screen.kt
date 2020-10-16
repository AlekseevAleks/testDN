package ru.lexxdroid.testdn.presentation.navigation

import ru.lexxdroid.testdn.presentation.newslist.NewsListFragment
import ru.lexxdroid.testdn.presentation.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen : SupportAppScreen() {

    override fun getScreenKey(): String = javaClass.name

    object Splash : Screen() {
        override fun getFragment() = SplashFragment()
    }

    object NewsList : Screen() {
        override fun getFragment() = NewsListFragment()
    }

    object Article : Screen() {
    }
}