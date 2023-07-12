package com.redwork.inc.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.login.LoginScreen
import com.redwork.inc.screens.auth.register_client.RegisterClientScreen
import com.redwork.inc.screens.auth.register_worker.RegisterWorkerScreen
import com.redwork.inc.screens.auth.roles.RolesScreen
import com.redwork.inc.screens.auth.splash.SplashScreen


fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Splash.route
    ) {
        composable(
            route = AuthScreen.Splash.route
        ) {
            SplashScreen(navController = navController)
        }

        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(
            route = AuthScreen.Roles.route,
            arguments = listOf(
                navArgument("phone") {
                    type = NavType.StringType
                }
            )
        ) {
            val phone = it.arguments?.getString("phone")

            RolesScreen(navController = navController, phone)
        }

        composable(
            route = AuthScreen.RegisterClient.route,
            arguments = listOf(
                navArgument("role") {
                    type = NavType.StringType
                },
                navArgument("phone") {
                    type = NavType.StringType
                }
            )
        ) {
            RegisterClientScreen(navController = navController)
        }

        composable(
            route = AuthScreen.RegisterWorker.route,
            arguments = listOf(
                navArgument("role") {
                    type = NavType.StringType
                },
                navArgument("phone") {
                    type = NavType.StringType
                }
            )
        ) {
            RegisterWorkerScreen(navController = navController)
        }

//        composable(route = Graph.CLIENT) {
//            ClientHomeScreen()
//        }

    }
}