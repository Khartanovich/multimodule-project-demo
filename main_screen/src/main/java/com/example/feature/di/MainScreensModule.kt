package com.example.feature.di

import com.example.api.MainScreen
import com.example.core.navigation.di.ScreensMap
import com.example.core.navigation.di.ScreensQualifier
import com.example.core.navigation.di.getScreen
import com.example.film_screen_api.FilmScreen
import dagger.Module
import dagger.Provides

@Module
internal class MainScreensModule {

    @Provides
    fun provideMainScreen(
        @ScreensQualifier screenMap: ScreensMap
    ): MainScreen{
        return screenMap.getScreen()
    }

    @Provides
    fun provideFilmScreen(
        @ScreensQualifier screenMap: ScreensMap
    ): FilmScreen {
        return screenMap.getScreen()
    }
}