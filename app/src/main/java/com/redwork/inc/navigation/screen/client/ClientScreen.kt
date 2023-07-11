package com.redwork.inc.navigation.screen.client

sealed class ClientScreen(
    val route: String
) {

    object Order: ClientScreen(route = "client/order")

}
