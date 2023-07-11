package com.redwork.inc.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.redwork.inc.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold() {
        RegisterContent(paddingValues = it)
    }
}