package ru.lexxdroid.testdn.domain.newslist

import ru.lexxdroid.testdn.domain.core.dto.Article

data class NewsListState(
    val articles: List<Article> = emptyList()
)