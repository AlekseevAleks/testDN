package ru.lexxdroid.testdn.presentation.newslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.lexxdroid.testdn.R
import ru.lexxdroid.testdn.presentation.core.adapter.DefaultListItemDiffUtilCallback

class ArticlesAdapter(
    private val onItemClick: (ArticleListItem) -> Unit,
    itemCallBack: DiffUtil.ItemCallback<ArticleListItem> = DefaultListItemDiffUtilCallback()
) : ListAdapter<ArticleListItem, ArticleViewHolder>(itemCallBack) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_acticle, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemId(position: Int) = getItem(position).id.toLong()

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}