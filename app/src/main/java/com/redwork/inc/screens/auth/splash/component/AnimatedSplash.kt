package com.redwork.inc.screens.auth.splash.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.redwork.inc.navigation.screen.auth.AuthScreen
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplash(navController: NavHostController, paddingValues: PaddingValues) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.navigate(route = AuthScreen.Login.route)
    }

    SplashContent(
        alpha = alphaAnim.value,
        paddingValues = paddingValues
    )
}