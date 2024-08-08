package com.example.feature.domin

import com.example.feature.domin.model.FilmModel

internal interface FilmRepository {

    suspend fun getPremiersMovies(year: Int, month: String): List<FilmModel>
}