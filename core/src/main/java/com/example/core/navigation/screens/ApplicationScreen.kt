package com.example.core.navigation.screens


//Предоставляет экраны для навигации

interface ApplicationScreen {
    val screenKey: String get() = this::class.java.name
}