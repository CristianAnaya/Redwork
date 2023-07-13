package com.redwork.inc.screens.auth.splash

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.splash.component.AnimatedSplash
import com.redwork.inc.screens.auth.splash.component.GetSession

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navController: NavHostController) {
    Scaffold() {
        AnimatedSplash(navController = navController ,paddingValues = it)
    }

    GetSession(navController)
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}