package com.example.film_screen.domain

import javax.inject.Inject

internal class GetIfoFilmUseCase @Inject constructor(
    private val repository: FilmInfoRepository
) {

    suspend fun getFilmInfo(filmId: Int): FilmInfoModel{
        return repository.getFilmInfo(filmId)
    }
}