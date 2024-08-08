package com.example.film_screen.di

import com.example.core.navigation.di.ScreensQualifier
import com.example.film_screen.api.FilmScreenImpl
import com.example.film_screen_api.FilmScreen
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface FilmScreenModule {

    @Binds
    fun bindFilmScreen(screen: FilmScreenImpl): FilmScreen

    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(FilmScreen::class)
    fun bindFilmScreenToMap(screen: FilmScreen): Any
}