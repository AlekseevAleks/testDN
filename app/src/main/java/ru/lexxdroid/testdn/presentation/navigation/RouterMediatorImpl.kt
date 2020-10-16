package ru.lexxdroid.testdn.presentation.navigation

import ru.terrakok.cicerone.Router
import javax.inject.Inject

class RouterMediatorImpl
@Inject constructor(
    private var router: Router
) : RouterMediator {

    override fun navigateToSplash() {
        router.newRootScreen(Screen.Splash)
    }

    override fun navigateToNewsList() {
        router.navigateTo(Screen.NewsList)
    }

    override fun navigateToArticle(url: String) {
    }
}