package com.example.multimoduleprojectfordemonstration

import com.example.api.MainScreen
import com.example.core.base.BaseViewModel
import com.example.core.navigation.routing.ApplicationNavigator
import com.example.core.navigation.routing.ApplicationRouter
import com.github.terrakok.cicerone.Cicerone
import javax.inject.Inject

internal class MainActivityViewModel @Inject constructor(
    router: ApplicationRouter,
    private val cicerone: Cicerone<ApplicationRouter>,
    mainScreen: MainScreen
) : BaseViewModel(
    router
) {

    init {
        router.newRootChain(mainScreen.invoke())
    }

    fun setNavigator(navigator: ApplicationNavigator) {
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    fun removeNavigator() {
        cicerone.getNavigatorHolder().removeNavigator()
    }

}