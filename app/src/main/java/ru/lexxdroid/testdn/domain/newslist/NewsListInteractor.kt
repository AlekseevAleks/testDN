package ru.lexxdroid.testdn.domain.newslist

import io.reactivex.Completable
import ru.lexxdroid.testdn.domain.core.Interactor

interface NewsListInteractor : Interactor<NewsListState> {

    fun loadNewsPage(page: Int): Completable
}