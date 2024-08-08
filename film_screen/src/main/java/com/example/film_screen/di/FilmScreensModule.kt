package com.example.film_screen.di

import com.example.core.navigation.di.ScreensMap
import com.example.core.navigation.di.ScreensQualifier
import com.example.core.navigation.di.getScreen
import com.example.film_screen_api.FilmScreen
import dagger.Module
import dagger.Provides

@Module
internal class FilmScreensModule {

    @Provides
    fun provideMainScreen(
        @ScreensQualifier screenMap: ScreensMap
    ): FilmScreen{
        return screenMap.getScreen()
    }
}