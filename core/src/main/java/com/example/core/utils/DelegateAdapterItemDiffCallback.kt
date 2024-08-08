package com.example.core.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

internal class DelegateAdapterItemDiffCallback : DiffUtil.ItemCallback<DelegateItem>() {
    override fun areItemsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean {
        return oldItem::class == newItem::class && oldItem.id() == newItem.id()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean {
        return oldItem.content() == newItem.content()
    }

    override fun getChangePayload(oldItem: DelegateItem, newItem: DelegateItem) =
        oldItem.payload(newItem)

}