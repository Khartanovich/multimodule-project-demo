package com.example.film_screen_api

import com.example.core.navigation.screens.ApplicationScreen
import com.github.terrakok.cicerone.Screen

interface FilmScreen: ApplicationScreen {
    operator fun invoke(filmId: Int): Screen
}