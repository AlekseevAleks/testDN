package ru.lexxdroid.testdn.data.network.response

import com.google.gson.annotations.SerializedName
import ru.lexxdroid.testdn.domain.core.dto.Article

data class NewsListResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("articles")
    val articles: List<ArticleResponse>
)

data class ArticleResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String
) {

    fun toArticle() = Article(title, description, url, urlToImage, publishedAt)
}