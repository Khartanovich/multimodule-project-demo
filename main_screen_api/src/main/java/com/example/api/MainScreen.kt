package com.example.api

import com.example.core.navigation.screens.ApplicationScreen
import com.github.terrakok.cicerone.Screen

interface MainScreen : ApplicationScreen {

    operator fun invoke(): Screen
}