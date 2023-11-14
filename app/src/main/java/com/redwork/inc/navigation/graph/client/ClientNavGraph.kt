package com.redwork.inc.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.client.ClientScreen
import com.redwork.inc.screens.client.available_category.AvailableCategoryScreen
import com.redwork.inc.screens.client.order.ClientOrderScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.Category.route
    ) {

        composable(route = ClientScreen.Category.route) {
            AvailableCategoryScreen(navController)
        }

        composable(route = ClientScreen.Order.route) {
            ClientOrderScreen(navController)
        }

    }
}