package ru.lexxdroid.testdn.presentation.newslist.adapter

import ru.lexxdroid.testdn.domain.core.dto.Article
import ru.lexxdroid.testdn.presentation.core.adapter.ListItem

data class ArticleListItem(
    override val id: Int,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String
) : ListItem

fun Article.toListItem() =
    ArticleListItem(hashCode(), title, description, url, urlToImage, publishedAt)