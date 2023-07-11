package com.redwork.inc.navigation.screen.auth



sealed class AuthScreen(val route: String) {
    object Splash: AuthScreen("splash")
    object OnBoarding: AuthScreen("onBoarding")
    object Login: AuthScreen("auth/login")
    object Roles: AuthScreen("auth/roles")
    object Register: AuthScreen("auth/register")
}
