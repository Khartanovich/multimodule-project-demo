package com.example.film_screen.data.dto

import com.example.film_screen.domain.FilmInfoModel
import javax.inject.Inject

internal class MapperDtoToModel @Inject constructor() {

    operator fun invoke(filmInfoDto: FilmInfoDto) = with(filmInfoDto) {
        FilmInfoModel(
            kinopoiskId = kinopoiskId,
            nameRu = nameRu,
            posterUrlPreview = posterUrlPreview,
            description = description,
            posterUrl = posterUrl
        )
    }
}