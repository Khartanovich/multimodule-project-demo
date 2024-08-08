package com.example.feature.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.navigation.routing.ApplicationRouter
import com.example.core.resources.AppResources
import com.example.feature.R
import com.example.feature.domin.GetPremiersUseCase
import com.example.feature.presentation.mapper.FilmModelToUiModelMapper
import com.example.film_screen_api.FilmScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MainScreenViewModel @Inject constructor(
    router: ApplicationRouter,
    private val getPremiersUseCase: GetPremiersUseCase,
    private val filmModelToUiModelMapper: FilmModelToUiModelMapper,
    private val resources: AppResources,
    private val filmScreen: FilmScreen,
) : BaseViewModel(router) {

    private val _state = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        getPremiers()
    }

    private fun getPremiers() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                _state.value = MainScreenState.Loading
                getPremiersUseCase.getPremiersMovies(2024, resources.getString(R.string.month))
            }.fold(
                onSuccess = {
                    _state.value = MainScreenState.Success(
                        it.map { filmModel -> filmModelToUiModelMapper(filmModel) }
                    )
                },
                onFailure = {
                    _state.value = MainScreenState.Error(it.message.toString())
                }
            )
        }
    }

    fun onFilmClick(filmId: Int) {
        router.navigateTo(filmScreen(filmId))
    }
}