package com.example.feature.di

import com.example.api.MainScreen
import com.example.core.navigation.di.ScreensQualifier
import com.example.feature.api.MainScreenImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface MainScreenModule {

    @Binds
    fun bindMainScreen(screen: MainScreenImpl): MainScreen

    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(MainScreen::class)
    fun bindMainScreenToMap(screen: MainScreen): Any
}