package com.redwork.inc.screens.auth.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.components.CircularIndicatorMessage
import com.redwork.inc.components.asString
import com.redwork.inc.screens.auth.login.LoginViewModel
import com.redwork.domain.core.Resource
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.auth.AuthScreen

@Composable
fun Login(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    when(val response = viewModel.loginResource) {
        is Resource.Loading -> {
            CircularIndicatorMessage(message = stringResource(id = R.string.please_wait))
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                response.data.user?.let {
                    navController.navigate(route = Graph.CLIENT) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                } ?: navController.navigate(route = AuthScreen.Roles.passPhone(viewModel.getPhone()))
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