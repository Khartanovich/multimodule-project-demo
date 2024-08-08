package com.example.core.app

import android.app.Application
import android.content.Context

interface AndroidDependenciesProvider {

    fun provideApplication(): Application

    fun provideContext(): Context
}