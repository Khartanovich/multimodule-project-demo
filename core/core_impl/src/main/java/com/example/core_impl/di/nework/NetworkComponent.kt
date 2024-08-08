package com.example.core_impl.di.nework

import com.example.core.network.NetworkProvider
import dagger.Component

@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider {

    companion object {
        fun init(): NetworkProvider {
            return DaggerNetworkComponent.factory().create()
        }
    }

    @Component.Factory
    interface Factory {
        fun create(): NetworkProvider
    }
}