package com.example.core_impl.di.android

import com.example.core.resources.AppResources
import com.example.core_impl.resources.AppResourcesImpl
import dagger.Binds
import dagger.Module

@Module
interface ResourcesModule {

    @Binds
    fun bindsAppResources(appResources: AppResourcesImpl): AppResources
}