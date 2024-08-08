package com.example.film_screen.di

import androidx.lifecycle.ViewModel
import com.example.core.base.di.ViewModelKey
import com.example.film_screen.presentation.FilmScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface FilmScreenViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FilmScreenViewModel::class)
    fun bindMainScreenViewModel(viewModel: FilmScreenViewModel): ViewModel
}