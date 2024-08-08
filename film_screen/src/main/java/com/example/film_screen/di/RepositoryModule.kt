package com.example.film_screen.di

import com.example.film_screen.data.FilmInfoRepositoryImpl
import com.example.film_screen.domain.FilmInfoRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bindsRepository(repositoryImpl: FilmInfoRepositoryImpl): FilmInfoRepository
}