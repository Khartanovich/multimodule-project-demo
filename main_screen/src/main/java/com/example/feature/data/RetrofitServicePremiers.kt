package com.example.feature.data

import com.example.feature.data.dto.ListFilmsDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val API_KEY = "ab18f47f-c8ce-4558-a356-3923662a6582"

internal interface RetrofitServicePremiers {

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/premieres")
    suspend fun getPremiersMovies(@Query("year") year: Int, @Query("month") month: String): ListFilmsDto
}