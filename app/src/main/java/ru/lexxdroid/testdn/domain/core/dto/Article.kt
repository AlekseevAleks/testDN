package ru.lexxdroid.testdn.domain.core.dto

data class Article(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String
)