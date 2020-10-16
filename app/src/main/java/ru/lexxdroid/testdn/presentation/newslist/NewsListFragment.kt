package ru.lexxdroid.testdn.presentation.newslist

import android.os.Bundle
import android.view.View
import ru.lexxdroid.testdn.R
import ru.lexxdroid.testdn.databinding.FragmentNewsListBinding
import ru.lexxdroid.testdn.domain.newslist.NewsListState
import ru.lexxdroid.testdn.presentation.core.BaseFragment
import ru.lexxdroid.testdn.presentation.newslist.adapter.ArticleListItem
import ru.lexxdroid.testdn.presentation.newslist.adapter.ArticlesAdapter
import ru.lexxdroid.testdn.presentation.newslist.adapter.toListItem

class NewsListFragment :
    BaseFragment<NewsListState, NewsListStateParcelable, NewsListPresenter>(R.layout.fragment_news_list),
    NewsListView {

    private lateinit var adapter: ArticlesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArticlesAdapter(::onArticleClick)
        FragmentNewsListBinding.bind(view).newsList.adapter = adapter
    }

    private fun onArticleClick(articleListItem: ArticleListItem) {
        presenter.onArticleClick(articleListItem)
    }


    override fun setState(state: NewsListState) {
        super.setState(state)
        adapter.submitList(state.articles.map { it.toListItem() }.toMutableList())
    }
}