package com.example.feature.data

import com.example.feature.data.mapper.FilmDtoToFilmModelMapper
import com.example.feature.domin.FilmRepository
import com.example.feature.domin.model.FilmModel
import javax.inject.Inject

internal class FilmRepositoryImpl @Inject constructor(
    private val retrofitServicePremiers: RetrofitServicePremiers,
    private val filmDtoToFilmModelMapper: FilmDtoToFilmModelMapper
) : FilmRepository {

    override suspend fun getPremiersMovies(year: Int, month: String): List<FilmModel> {
        val response = retrofitServicePremiers.getPremiersMovies(year, month)
        return response.items.map { filmDtoToFilmModelMapper(it) }
    }
}