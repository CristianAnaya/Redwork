package com.redwork.inc.screens.auth.onboarding.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.domain.core.Resource
import com.redwork.inc.components.asString
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.onboarding.OnBoardingViewModel

@Composable
fun SaveFirstTime(navController: NavHostController, viewModel: OnBoardingViewModel = hiltViewModel()) {

    when(val response = viewModel.saveFirstTimeResource) {
        is Resource.Loading -> {}
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Login.route)
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