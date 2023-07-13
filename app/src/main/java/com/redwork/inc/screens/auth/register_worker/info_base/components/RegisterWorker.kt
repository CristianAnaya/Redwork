package com.redwork.inc.screens.auth.register_worker.info_base.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.domain.core.Resource
import com.redwork.inc.R.string.please_wait
import com.redwork.inc.components.CircularIndicatorMessage
import com.redwork.inc.components.asString
import com.redwork.inc.navigation.Graph
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.register_worker.info_base.RegisterWorkerViewModel

@Composable
fun RegisterWorker(
    navController: NavHostController,
    viewModel: RegisterWorkerViewModel = hiltViewModel()
) {
    when(val response = viewModel.registerResource) {
        is Resource.Loading -> {
            CircularIndicatorMessage(message = stringResource(id = please_wait))
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(
                    route = AuthScreen.CompleteInfo.route,
                    builder = {
                        popUpTo(AuthScreen.RegisterWorker.route) {
                            inclusive = false
                        }
                    }
                )
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