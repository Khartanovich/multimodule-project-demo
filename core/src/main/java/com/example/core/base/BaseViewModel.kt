package com.example.core.base

import androidx.lifecycle.ViewModel
import com.example.core.navigation.routing.ApplicationRouter

abstract class BaseViewModel(
    protected val router: ApplicationRouter
) : ViewModel() {
}