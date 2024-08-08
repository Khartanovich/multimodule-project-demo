package com.example.core.app

import com.example.core.resources.AppResources

interface ResourcesProvider : AndroidDependenciesProvider {
    fun provideAppResources(): AppResources
}