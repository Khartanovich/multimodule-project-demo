package com.example.core.app

import com.example.core.navigation.di.NavigationProvider
import com.example.core.navigation.di.ScreensMapProvider
import com.example.core.network.NetworkProvider

interface ApplicationProvider :
    ResourcesProvider,
    NavigationProvider,
    ScreensMapProvider,
    NetworkProvider