package com.redwork.inc.navigation.screen.auth



sealed class AuthScreen(val route: String) {
    object Splash: AuthScreen("splash")
    object OnBoarding: AuthScreen("onBoarding")
    object Login: AuthScreen("auth/login")
    object Roles: AuthScreen("auth/roles") {
        fun passPhone(phone: String) = "auth/roles/$phone"
    }
    object RegisterClient: AuthScreen("auth/register_client/{role}/{phone}") {
        fun passRole(role: String, phone: String) = "auth/register_client/$role/$phone"
    }
    object RegisterWorker: AuthScreen("auth/register_worker/{role}/{phone}") {
        fun passRole(role: String, phone: String) = "auth/register_worker/$role/$phone"
    }
}
