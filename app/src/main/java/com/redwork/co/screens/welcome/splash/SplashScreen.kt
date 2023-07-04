package com.redwork.co.screens.welcome.splash

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.co.screens.welcome.splash.component.AnimatedSplash
import com.redwork.co.screens.welcome.splash.component.SplashContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navController: NavHostController) {
    Scaffold() {
        AnimatedSplash(navController = navController ,paddingValues = it)
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}