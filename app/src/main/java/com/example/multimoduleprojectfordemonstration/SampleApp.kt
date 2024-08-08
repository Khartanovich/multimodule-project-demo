package com.example.multimoduleprojectfordemonstration

import android.app.Application
import com.example.core.app.App
import com.example.core.app.ApplicationProvider
import com.example.multimoduleprojectfordemonstration.di.ApplicationComponent

internal class SampleApp : Application(), App {

    lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }
}