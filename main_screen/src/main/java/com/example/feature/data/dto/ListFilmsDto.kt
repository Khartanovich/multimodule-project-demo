package com.example.feature.data.dto

import com.google.gson.annotations.SerializedName

internal data class ListFilmsDto(
    @SerializedName("total")
    val total: Int,
    @SerializedName("items")
    val items: List<FilmDto>
)
