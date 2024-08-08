package com.example.multimoduleprojectfordemonstration.di

import com.example.core.app.ApplicationProvider
import com.example.multimoduleprojectfordemonstration.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        ScreensBinding::class,
        MainActivityViewModelsModule::class,
    ]
)
interface MainActivityComponent {

    companion object {
        fun init(applicationProvider: ApplicationProvider): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(applicationProvider)
        }
    }

    @Component.Factory
    interface MainComponentFactory {

        fun create(applicationProvider: ApplicationProvider): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}