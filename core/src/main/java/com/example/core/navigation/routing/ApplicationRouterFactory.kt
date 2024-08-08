package com.example.core.navigation.routing

import javax.inject.Inject

//"Use-case" для создания маршрутизатора приложений.
// * Используется в viewModel для создания локальных маршрутизаторов.
class ApplicationRouterFactory @Inject constructor() {
    operator fun invoke() = ApplicationRouter()
}