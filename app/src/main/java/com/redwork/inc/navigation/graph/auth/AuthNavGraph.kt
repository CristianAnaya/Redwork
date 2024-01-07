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
import com.redwork.inc.screens.auth.onboarding.OnBoardingScreen
import com.redwork.inc.screens.auth.register_client.RegisterClientScreen
import com.redwork.inc.screens.auth.register_worker.choose_address.ChooseAddressScreen
import com.redwork.inc.screens.auth.register_worker.complete_info.CompleteInfoScreen
import com.redwork.inc.screens.auth.register_worker.info_base.RegisterWorkerScreen
import com.redwork.inc.screens.auth.register_worker.select_address.SelectAddressScreen
import com.redwork.inc.screens.auth.register_worker.selected_category.SelectedCategoryScreen
import com.redwork.inc.screens.auth.roles.RolesScreen
import com.redwork.inc.screens.auth.splash.SplashScreen
import com.redwork.inc.screens.client.home.ClientHomeScreen
import com.redwork.inc.screens.client.main.ClientMainScreen


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

        composable(route = AuthScreen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
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

        composable(route = AuthScreen.CompleteInfo.route) {
            CompleteInfoScreen(navController = navController)
        }

        composable(route = AuthScreen.SelectedCategory.route) {
            SelectedCategoryScreen(navController = navController)
        }

        composable(route = AuthScreen.ChooseAddress.route) {
            ChooseAddressScreen(navController = navController)
        }

        composable(route = AuthScreen.SelectAddress.route) {
            SelectAddressScreen(navController = navController)
        }

        composable(route = Graph.CLIENT) {
            ClientMainScreen()
        }

    }
}