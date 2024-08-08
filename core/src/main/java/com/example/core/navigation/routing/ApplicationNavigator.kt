package com.example.core.navigation.routing

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.androidx.AppNavigator

//Применяет команды к указанному диспетчеру фрагментов
class ApplicationNavigator (
    activity: FragmentActivity,
    containerId: Int,
    fragmentManager: FragmentManager = activity.supportFragmentManager
) : AppNavigator(activity, containerId, fragmentManager) {
}