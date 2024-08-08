package com.example.core.view.itemfilmcard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.core.databinding.ItemFilmCardBinding
import com.example.core.extensions.loadImageFromUrl

class ItemFilmCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: ItemFilmCardBinding =
        ItemFilmCardBinding.inflate(LayoutInflater.from(context), this, true)

    fun populate(model: ItemFilmUiModel, onClick: (ItemFilmUiModel) -> Unit) {
        with(binding) {
            imgPosterUrlPreview.loadImageFromUrl(model.posterUrlPreview)
            tvNameRu.text = model.nameRu
            root.setOnClickListener {
                onClick(model)
            }
        }
    }
}