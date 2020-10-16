package ru.lexxdroid.testdn.presentation.newslist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.lexxdroid.testdn.databinding.ItemActicleBinding

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemActicleBinding.bind(itemView)

    fun bind(
        article: ArticleListItem,
        onItemClick: (ArticleListItem) -> Unit
    ) {
        with(binding) {
            title.text = article.title
            description.text = article.description
            date.text = article.publishedAt
        }
        itemView.setOnClickListener { onItemClick(article) }
    }
}
