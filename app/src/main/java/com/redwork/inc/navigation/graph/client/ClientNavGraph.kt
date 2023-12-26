package com.redwork.inc.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.client.ClientScreen
import com.redwork.inc.screens.client.available_category.AvailableCategoryScreen
import com.redwork.inc.screens.client.history.ClientHistoryScreen
import com.redwork.inc.screens.client.order.ClientOrderScreen
import com.redwork.inc.screens.client.profile.ClientProfileScreen
import com.redwork.inc.screens.client.report.ClientReportScreen
import com.redwork.inc.screens.client.settings.ClientSettingsScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.Home.route
    ) {

        composable(route = ClientScreen.Home.route) {
            AvailableCategoryScreen(navController)
        }

        composable(route = ClientScreen.Profile.route) {
            ClientProfileScreen(navController)
        }

        composable(route = ClientScreen.History.route) {
            ClientHistoryScreen(navController)
        }

        composable(route = ClientScreen.Report.route) {
            ClientReportScreen(navController)
        }

        composable(route = ClientScreen.Settings.route) {
            ClientSettingsScreen(navController)
        }

    }
}