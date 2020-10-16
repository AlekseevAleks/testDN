package ru.lexxdroid.testdn.data.network

import io.reactivex.Single
import ru.lexxdroid.testdn.data.network.response.ArticleResponse
import ru.lexxdroid.testdn.domain.core.dto.Article
import javax.inject.Inject

class NewsDataSource
@Inject constructor(private val newsApi: NewsApi) : NewsSource {

    override fun getNewsPage(page: Int): Single<List<Article>> {
        return newsApi.getNews(page)
            .map { response -> response.articles.map(ArticleResponse::toArticle) }
    }
}