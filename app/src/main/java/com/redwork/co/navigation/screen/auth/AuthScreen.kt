package com.redwork.co.navigation.screen.auth


sealed class AuthScreen(val route: String) {
    object Splash: AuthScreen("splash")
    object OnBoarding: AuthScreen("onBoarding")
    object Login: AuthScreen("auth/login")
    object Register: AuthScreen("auth/register")
}
