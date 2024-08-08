package com.example.multimoduleprojectfordemonstration.di

import com.example.feature.di.MainScreenModule
import com.example.film_screen.di.FilmScreenModule
import dagger.Module

@Module(
    includes = [
        MainScreenModule::class,
        FilmScreenModule::class
    ]
)
interface ScreensBinding