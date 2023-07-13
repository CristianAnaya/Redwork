package com.redwork.inc.screens.auth.splash.component

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.domain.core.Resource
import com.redwork.inc.components.asString
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.splash.SplashViewModel

@Composable
fun GetSession(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    val isFirstTime by viewModel.isFirstTime.collectAsState()

    when(val response = viewModel.sessionResource) {
        is Resource.Loading -> {}
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                Log.d("Success", "GetSession: ${isFirstTime}")
                if (isFirstTime == true) {
                    navController.navigate(route = AuthScreen.OnBoarding.route)
                } else {
                    response.data.user?.let {
                        navController.navigate(route = Graph.CLIENT) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    } ?: navController.navigate(route = AuthScreen.Login.route)
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, asString(uiText = response.message), Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null)
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
        }
    }

}