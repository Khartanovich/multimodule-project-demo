package com.example.film_screen.presentation

import com.example.film_screen.domain.FilmInfoModel

internal sealed class FilmScreenState {
        data object Loading: FilmScreenState()
        data class Success(val filmInfo: FilmInfoModel): FilmScreenState()
        data class Error(val message: String): FilmScreenState()
}