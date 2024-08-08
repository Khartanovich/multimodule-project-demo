package com.example.feature.presentation.mapper

import com.example.core.view.itemfilmcard.ItemFilmUiModel
import com.example.feature.domin.model.FilmModel
import javax.inject.Inject

internal class FilmModelToUiModelMapper @Inject constructor() {

    operator fun invoke(filmModel: FilmModel) = with(filmModel) {
        ItemFilmUiModel(
            kinopoiskId = kinopoiskId,
            nameRu = nameRu,
            posterUrlPreview = posterUrlPreview
        )
    }
}