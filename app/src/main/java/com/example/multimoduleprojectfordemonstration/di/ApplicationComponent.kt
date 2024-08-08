package com.example.multimoduleprojectfordemonstration.di

import com.example.core.app.ApplicationProvider
import com.example.core.app.ResourcesProvider
import com.example.core.base.di.ViewModelFactoryModule
import com.example.core.navigation.di.NavigationProvider
import com.example.core.network.NetworkProvider
import com.example.core_impl.di.android.ResourcesDependenciesComponent
import com.example.core_impl.di.navigation.NavigationComponent
import com.example.core_impl.di.nework.NetworkComponent
import com.example.multimoduleprojectfordemonstration.SampleApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        NavigationProvider::class,
        ResourcesProvider::class,
        NetworkProvider::class
    ],
    modules = [
        ViewModelFactoryModule::class,
        ScreensBinding::class
    ]
)
internal interface ApplicationComponent : ApplicationProvider {

    companion object {
        fun init(app: SampleApp): ApplicationProvider {
            return DaggerApplicationComponent.factory()
                .create(
                    coreDependenciesProvider = ResourcesDependenciesComponent.create(app),
                    navigationProvider = NavigationComponent.init(),
                    networkProvider = NetworkComponent.init()
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            coreDependenciesProvider: ResourcesProvider,
            navigationProvider: NavigationProvider,
            networkProvider: NetworkProvider
        ): ApplicationComponent
    }

    fun inject(app: SampleApp)
}