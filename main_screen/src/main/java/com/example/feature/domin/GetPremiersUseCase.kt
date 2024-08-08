package com.example.feature.domin

import com.example.feature.domin.model.FilmModel
import javax.inject.Inject

internal class GetPremiersUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    suspend fun getPremiersMovies(year: Int, month: String): List<FilmModel> {
        return repository.getPremiersMovies(year, month)
    }
}