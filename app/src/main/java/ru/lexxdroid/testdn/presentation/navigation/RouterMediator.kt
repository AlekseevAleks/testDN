package ru.lexxdroid.testdn.presentation.navigation

interface RouterMediator {

    fun navigateToSplash()

    fun navigateToNewsList()

    fun navigateToArticle(url: String)
}