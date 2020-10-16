package ru.lexxdroid.testdn.data.network

import io.reactivex.Single
import ru.lexxdroid.testdn.domain.core.dto.Article

interface
NewsSource {

    fun getNewsPage(page: Int): Single<List<Article>>
}