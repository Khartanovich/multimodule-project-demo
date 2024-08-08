package com.example.core.navigation.di

import com.example.core.navigation.routing.ApplicationRouter
import com.github.terrakok.cicerone.Cicerone

interface NavigationProvider {

    fun provideCicerone(): Cicerone<ApplicationRouter>

    fun provideRouter(): ApplicationRouter
}