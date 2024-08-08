package com.example.multimoduleprojectfordemonstration.di

import androidx.lifecycle.ViewModel
import com.example.core.base.di.ViewModelKey
import com.example.multimoduleprojectfordemonstration.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface MainActivityViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun bindMainViewModel(viewModel: MainActivityViewModel): ViewModel
}