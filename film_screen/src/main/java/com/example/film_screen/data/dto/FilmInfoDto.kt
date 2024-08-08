package com.example.film_screen.data.dto

import com.google.gson.annotations.SerializedName

internal data class FilmInfoDto(
    @SerializedName("description")
    val description: String?,
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int?,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("posterUrl")
    val posterUrl: String?,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String?,
)