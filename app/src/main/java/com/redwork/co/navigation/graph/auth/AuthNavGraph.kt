package com.redwork.co.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.redwork.co.navigation.Graph
import com.redwork.co.navigation.screen.auth.AuthScreen
import com.redwork.co.screens.auth.login.LoginScreen
import com.redwork.co.screens.welcome.splash.SplashScreen


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

    }
}