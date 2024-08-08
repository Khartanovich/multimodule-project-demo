package com.example.feature.data.dto

import com.google.gson.annotations.SerializedName

internal data class FilmDto(
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int,
    @SerializedName("nameRu")
    val nameRu: String,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("premiereRu")
    val premiereRu: String,
    @SerializedName("countries")
    val countries: List<CountryDto>,
    @SerializedName("filmId")
    val filmId: Int,
)

data class GenreDto(
    @SerializedName("genre")
    val genre: String
)

data class CountryDto(
    @SerializedName("country")
    val country: String
)
