package com.example.feature.di

import androidx.lifecycle.ViewModel
import com.example.core.base.di.ViewModelKey
import com.example.feature.presentation.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface MainScreenViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun bindMainScreenViewModel(viewModel: MainScreenViewModel): ViewModel
}