package com.redwork.inc.navigation.screen.client

sealed class ClientScreen(
    val route: String
) {

    object Category: ClientScreen(route = "client/category")
    object Order: ClientScreen(route = "client/order")

}
