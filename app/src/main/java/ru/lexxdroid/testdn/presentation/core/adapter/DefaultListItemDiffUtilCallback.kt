package ru.lexxdroid.testdn.presentation.core.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DefaultListItemDiffUtilCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.javaClass == newItem.javaClass && oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem

    override fun getChangePayload(oldItem: T, newItem: T) = Unit
}