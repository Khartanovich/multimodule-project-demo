package com.example.film_screen.data

import com.example.film_screen.data.dto.MapperDtoToModel
import com.example.film_screen.domain.FilmInfoModel
import com.example.film_screen.domain.FilmInfoRepository
import javax.inject.Inject

internal class FilmInfoRepositoryImpl @Inject constructor(
    private val retrofitServicePremiers: RetrofitServiceFilmInfo,
    private val filmDtoToFilmModelMapper: MapperDtoToModel
) : FilmInfoRepository {

    override suspend fun getFilmInfo(filmId: Int): FilmInfoModel {
        val response = retrofitServicePremiers.getInfoAboutFilm(filmId)
        return filmDtoToFilmModelMapper(response)
    }
}