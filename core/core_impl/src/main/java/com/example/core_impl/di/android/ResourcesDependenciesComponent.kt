package com.example.core_impl.di.android

import android.app.Application
import com.example.core.app.ResourcesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidDependenciesModule::class,
        ResourcesModule::class
    ]
)
interface ResourcesDependenciesComponent : ResourcesProvider {

    fun inject(application: Application)

    companion object {

        fun create(app: Application): ResourcesProvider {
            return DaggerResourcesDependenciesComponent.builder()
                .androidDependenciesModule(AndroidDependenciesModule(app))
                .build()
        }
    }
}