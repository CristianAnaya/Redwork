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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.splash.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplash(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: SplashViewModel = hiltViewModel()
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 4000
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        viewModel.getSessionData()
    }

    SplashContent(
        alpha = alphaAnim.value,
        paddingValues = paddingValues
    )
}