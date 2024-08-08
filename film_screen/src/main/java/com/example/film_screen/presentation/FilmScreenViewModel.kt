package com.example.film_screen.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.navigation.routing.ApplicationRouter
import com.example.film_screen.domain.GetIfoFilmUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class FilmScreenViewModel @Inject constructor(
    router: ApplicationRouter,
    private val useCase: GetIfoFilmUseCase,
    private val filmId: Int
) : BaseViewModel(router) {

    private val _state = MutableStateFlow<FilmScreenState>(
        FilmScreenState.Loading
    )
    val state = _state.asStateFlow()

    init {
        getFilmInfo()
    }

    private fun getFilmInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                useCase.getFilmInfo(filmId)
            }.fold(
                onSuccess = { _state.value = FilmScreenState.Success(it) },
                onFailure = {
                    _state.value = FilmScreenState.Error(it.message.toString())
                }
            )
        }
    }
}