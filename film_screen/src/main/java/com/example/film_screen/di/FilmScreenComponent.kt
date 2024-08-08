package com.example.film_screen.di

import com.example.core.app.ApplicationProvider
import com.example.film_screen.presentation.FilmScreenFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [ApplicationProvider::class],
    modules = [
        FilmScreenViewModelModule::class,
        FilmScreensModule::class,
        RepositoryModule::class,
        NetworkModule::class,
    ]
)
internal interface FilmScreenComponent {

    companion object {
        fun init(
            applicationProvider: ApplicationProvider,
            filmId: Int
        ): FilmScreenComponent {
            return DaggerFilmScreenComponent.factory().create(applicationProvider, filmId)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance filmId: Int
        ): FilmScreenComponent
    }

    fun inject(fragment: FilmScreenFragment)
}