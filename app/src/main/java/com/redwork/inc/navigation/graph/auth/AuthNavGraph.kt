package com.redwork.inc.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.login.LoginScreen
import com.redwork.inc.screens.auth.register.RegisterScreen
import com.redwork.inc.screens.auth.roles.RolesScreen
import com.redwork.inc.screens.client.home.ClientHomeScreen
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

        composable(route = AuthScreen.Roles.route) {
            RolesScreen(navController = navController)
        }

        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController = navController)
        }

//        composable(route = Graph.CLIENT) {
//            ClientHomeScreen()
//        }

    }
}