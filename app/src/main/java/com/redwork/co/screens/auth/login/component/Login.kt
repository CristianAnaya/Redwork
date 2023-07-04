package com.redwork.co.screens.auth.login.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.co.R
import com.redwork.co.components.CircularIndicatorMessage
import com.redwork.co.screens.auth.login.LoginViewModel
import com.redwork.domain.core.Resource

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
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null)
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
        }
    }
}