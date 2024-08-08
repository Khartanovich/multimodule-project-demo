package com.example.feature.api

import com.example.api.MainScreen
import com.example.feature.presentation.MainScreenFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class MainScreenImpl @Inject constructor (): MainScreen {

    override fun invoke(): Screen = FragmentScreen(null){
        MainScreenFragment.newInstance()
    }
}