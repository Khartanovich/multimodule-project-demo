package com.example.feature.data.mapper

import com.example.feature.data.dto.FilmDto
import com.example.feature.domin.model.FilmModel
import javax.inject.Inject

internal class FilmDtoToFilmModelMapper @Inject constructor() {

    operator fun invoke(filmModel: FilmDto) = with(filmModel){
        FilmModel(
            kinopoiskId = kinopoiskId,
            nameRu = nameRu,
            posterUrlPreview = posterUrlPreview
        )
    }
}