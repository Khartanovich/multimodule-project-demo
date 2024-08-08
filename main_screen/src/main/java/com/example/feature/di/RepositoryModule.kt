package com.example.feature.di

import com.example.feature.data.FilmRepositoryImpl
import com.example.feature.domin.FilmRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bindsRepository(repositoryImpl: FilmRepositoryImpl): FilmRepository
}