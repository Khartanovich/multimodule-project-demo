package com.example.core_impl.di.navigation

import com.example.core.navigation.di.NavigationProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationProvider {


    companion object {

        fun init(): NavigationProvider {
            return DaggerNavigationComponent.factory().create()
        }
    }

    @Component.Factory
    interface Factory {

        fun create(): NavigationProvider
    }
}