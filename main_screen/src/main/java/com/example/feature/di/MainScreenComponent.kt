package com.example.feature.di

import com.example.core.app.ApplicationProvider
import com.example.feature.presentation.MainScreenFragment
import dagger.Component

@Component(
    dependencies = [ApplicationProvider::class],
    modules = [
        MainScreenViewModelModule::class,
        MainScreensModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
internal interface MainScreenComponent {

    companion object {
        fun init(applicationProvider: ApplicationProvider): MainScreenComponent {
            return DaggerMainScreenComponent.factory().create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(applicationProvider: ApplicationProvider): MainScreenComponent
    }

    fun inject(fragment: MainScreenFragment)
}