package com.example.core.view.itemfilmcard

import com.example.core.utils.DelegateItem

data class ItemFilmUiModel(
    val kinopoiskId: Int,
    val nameRu: String,
    val posterUrlPreview: String
) : DelegateItem {
    override fun id(): Any {
        return kinopoiskId
    }
}