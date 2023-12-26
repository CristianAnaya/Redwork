package com.redwork.inc.navigation.screen.client

sealed class ClientScreen(
    val route: String
) {

    // Navigation bar
    object Home: ClientScreen(route = "client/home")
    object Chat: ClientScreen(route = "client/chat")
    object Request: ClientScreen(route = "client/request")

    // Navigation drawer
    object Profile: ClientScreen(route = "client/profile")
    object History: ClientScreen(route = "client/history")
    object Report: ClientScreen(route = "client/report")
    object Settings: ClientScreen(route = "client/settings")

}
