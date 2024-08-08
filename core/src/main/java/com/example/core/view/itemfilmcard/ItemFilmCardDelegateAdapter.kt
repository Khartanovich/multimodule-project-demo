package com.example.core.view.itemfilmcard

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.utils.DelegateAdapter
import com.example.core.utils.DelegateItem

class ItemFilmCardDelegateAdapter(
    private val onClick: (ItemFilmUiModel) -> Unit
) :
    DelegateAdapter<ItemFilmUiModel, ItemFilmCardDelegateAdapter.ItemFilmCardViewHolder>(
        ItemFilmUiModel::class.java
    ) {

    class ItemFilmCardViewHolder(
        private val itemFilmCardView: ItemFilmCardView,
    ) : RecyclerView.ViewHolder(itemFilmCardView) {

        fun bind(model: ItemFilmUiModel, onClick: (ItemFilmUiModel) -> Unit) {
            itemFilmCardView.apply {
                populate(model, onClick = onClick)
            }
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = ItemFilmCardView(parent.context)
        return ItemFilmCardViewHolder(view)
    }

    override fun bindViewHolder(
        model: ItemFilmUiModel,
        viewHolder: ItemFilmCardViewHolder,
        payloads: List<List<DelegateItem.Payloadable>>
    ) {
        viewHolder.bind(model, onClick)
    }
}