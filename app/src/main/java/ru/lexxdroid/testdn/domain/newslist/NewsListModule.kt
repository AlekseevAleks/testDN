package ru.lexxdroid.testdn.domain.newslist

import dagger.Binds
import dagger.Module

@Module
interface NewsListModule {

    @Binds
    fun bindNewsListInteractor(newsListModel: NewsListModel): NewsListInteractor
}