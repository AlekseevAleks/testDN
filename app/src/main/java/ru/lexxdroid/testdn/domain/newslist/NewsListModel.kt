package ru.lexxdroid.testdn.domain.newslist

import io.reactivex.Completable
import ru.lexxdroid.testdn.data.network.NewsSource
import ru.lexxdroid.testdn.domain.core.BaseModel
import ru.lexxdroid.testdn.domain.schedule.Schedulers
import javax.inject.Inject

class NewsListModel
@Inject constructor(
    private val newsSource: NewsSource,
    private val schedulers: Schedulers
) : BaseModel<NewsListState>(NewsListState()), NewsListInteractor {

    override fun loadNewsPage(page: Int): Completable =
        newsSource.getNewsPage(page)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doOnSuccess {
                updateState {
                    copy(articles = articles + it)
                }
            }
            .ignoreElement()
}

