package com.example.film_screen.domain

internal interface FilmInfoRepository {

    suspend fun getFilmInfo(filmId: Int): FilmInfoModel
}