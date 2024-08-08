package com.example.core.navigation.di

import com.example.core.navigation.screens.ApplicationScreen
import javax.inject.Provider

typealias ScreensMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>


interface ScreensMapProvider {

    @ScreensQualifier
    fun provideScreensMap(): ScreensMap
}

inline fun <reified T : ApplicationScreen> ScreensMap.getScreen(): T {
    return (getValue(T::class.java) as Provider<T>).get()
}