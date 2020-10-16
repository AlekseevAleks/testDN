package ru.lexxdroid.testdn.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.lexxdroid.testdn.data.network.response.NewsListResponse

interface NewsApi {

    @GET("everything?q=android&from=2019-04-00&sortBy=publishedAt&apiKey=26eddb253e7840f988aec61f2ece2907")
    fun getNews(
        @Query("page") page: Int
    ): Single<NewsListResponse>
}