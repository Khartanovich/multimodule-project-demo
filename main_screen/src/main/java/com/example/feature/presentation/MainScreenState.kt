package com.example.feature.presentation

import com.example.core.view.itemfilmcard.ItemFilmUiModel

internal sealed class MainScreenState {
    data object Loading: MainScreenState()
    data class Success(val listFilm: List<ItemFilmUiModel>): MainScreenState()
    data class Error(val message: String): MainScreenState()
}