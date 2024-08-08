package com.example.film_screen.api

import com.example.film_screen.presentation.FilmScreenFragment
import com.example.film_screen_api.FilmScreen
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class FilmScreenImpl @Inject constructor(): FilmScreen {

    override fun invoke(filmId: Int): Screen = FragmentScreen(key = screenKey){
        FilmScreenFragment.newInstance(filmId)
    }
}