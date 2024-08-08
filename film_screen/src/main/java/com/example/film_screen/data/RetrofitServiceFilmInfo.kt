package com.example.film_screen.data

import com.example.film_screen.data.dto.FilmInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private const val API_KEY = "ab18f47f-c8ce-4558-a356-3923662a6582"

internal interface RetrofitServiceFilmInfo {

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/{id}")
    suspend fun getInfoAboutFilm(@Path("id") id: Int): FilmInfoDto
}