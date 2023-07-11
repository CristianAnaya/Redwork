package com.redwork.inc.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.redwork.inc.R.string.please_wait
import com.redwork.inc.components.CircularIndicatorMessage
import com.redwork.inc.components.asString
import com.redwork.inc.screens.auth.login.LoginViewModel
import com.redwork.domain.core.Resource

@Composable
fun GetOTP(viewModel: LoginViewModel = hiltViewModel()) {

    when(val response = viewModel.otpResource) {
        is Resource.Loading -> {
            CircularIndicatorMessage(message = stringResource(id = please_wait))
        }
        is Resource.Success -> {
            viewModel.onValidationId(response.data)
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