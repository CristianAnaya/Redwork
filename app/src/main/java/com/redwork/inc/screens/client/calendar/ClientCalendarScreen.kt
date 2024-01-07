package com.redwork.inc.screens.client.calendar

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.redwork.inc.screens.client.calendar.components.ClientCalendarContent

@Composable
fun ClientCalendarScreen(
    navController: NavHostController
) {
    Scaffold(
        containerColor = Color.White
    ) {
        ClientCalendarContent(paddingValues = it)
    }
}