package com.example.core_impl.di.navigation

import com.example.core.navigation.routing.ApplicationRouter
import com.example.core.navigation.routing.ApplicationRouterFactory
import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideApplicationCicerone(router: ApplicationRouter): Cicerone<ApplicationRouter> {
        return Cicerone.create(router)
    }

    @Provides
    @Singleton
    fun provideApplicationRouter(applicationRouterFactory: ApplicationRouterFactory): ApplicationRouter {
        return applicationRouterFactory()
    }

}