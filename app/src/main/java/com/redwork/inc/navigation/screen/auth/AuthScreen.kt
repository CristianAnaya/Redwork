package com.redwork.inc.navigation.screen.auth



sealed class AuthScreen(val route: String) {
    object Splash: AuthScreen("auth/splash")
    object OnBoarding: AuthScreen("auth/onBoarding")
    object Login: AuthScreen("auth/login")
    object Roles: AuthScreen("auth/roles/{phone}") {
        fun passPhone(phone: String) = "auth/roles/$phone"
    }
    object RegisterClient: AuthScreen("auth/register_client/{role}/{phone}") {
        fun passRole(role: String, phone: String) = "auth/register_client/$role/$phone"
    }
    object RegisterWorker: AuthScreen("auth/register_worker/{role}/{phone}") {
        fun passRole(role: String, phone: String) = "auth/register_worker/$role/$phone"
    }
    object CompleteInfo: AuthScreen("auth/register_worker/complete_info")
    object SelectedCategory: AuthScreen("auth/register_worker/selected_category")
}
