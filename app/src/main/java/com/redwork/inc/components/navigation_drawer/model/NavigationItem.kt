package com.redwork.inc.components.navigation_drawer.model

import com.redwork.inc.R
import com.redwork.inc.navigation.screen.client.ClientScreen

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home: NavigationItem(ClientScreen.Home.route, R.drawable.round_home, "Inicio")
    object Profile: NavigationItem(ClientScreen.Profile.route, R.drawable.round_person, "Perfil")
    object Calendar: NavigationItem(ClientScreen.Request.route, R.drawable.baseline_calendar, "Tu Agenda")
    object History: NavigationItem(ClientScreen.History.route, R.drawable.round_home, "Tu historial")
    object Settings: NavigationItem(ClientScreen.Settings.route, R.drawable.round_settings_24, "Configuración")
}
