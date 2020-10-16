package ru.lexxdroid.testdn.presentation.newslist

import io.reactivex.rxkotlin.subscribeBy
import ru.lexxdroid.testdn.domain.newslist.NewsListInteractor
import ru.lexxdroid.testdn.domain.newslist.NewsListState
import ru.lexxdroid.testdn.domain.schedule.Schedulers
import ru.lexxdroid.testdn.presentation.core.BasePresenter
import ru.lexxdroid.testdn.presentation.error.ErrorUtils
import ru.lexxdroid.testdn.presentation.navigation.RouterMediator
import ru.lexxdroid.testdn.presentation.newslist.adapter.ArticleListItem
import javax.inject.Inject

class NewsListPresenter
@Inject constructor(
    router: RouterMediator,
    interactor: NewsListInteractor,
    schedulers: Schedulers
) : BasePresenter<NewsListState, NewsListView, NewsListInteractor>(
    router, interactor, schedulers
) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposeOnDestroy(
            interactor.loadNewsPage(1)
                .observeOn(schedulers.main())
                .subscribeBy(onError = ErrorUtils::onError)
        )
    }

    fun onArticleClick(articleListItem: ArticleListItem) {
        router.navigateToArticle(articleListItem.url)
    }
}