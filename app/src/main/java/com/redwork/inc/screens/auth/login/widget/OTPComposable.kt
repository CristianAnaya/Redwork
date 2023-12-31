package com.redwork.inc.screens.auth.login.widget

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.redwork.inc.R
import com.redwork.inc.components.SizedBox
import com.redwork.inc.screens.auth.login.LoginViewModel
import com.redwork.inc.ui.theme.black20Bold
import com.redwork.inc.ui.theme.gray15
import com.redwork.inc.ui.theme.gray20Bold

@Composable
fun OTPComposable(
    viewModel: LoginViewModel = viewModel()
) {
    val state = viewModel.state

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    AnimatedVisibility(
        visible = viewModel.state.validationId.isNotEmpty(),
    ) {
        Column {
            SizedBox(height = 20)
            Text(
                stringResource(id = R.string.enter_otp),
                style = gray15
            )
            SizedBox(height = 10)
            TextField(
                value = state.otp,
                textStyle = black20Bold,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                onValueChange = { viewModel.onOTPInput(it) },
                placeholder = {
                    Text(
                        stringResource(id = R.string.otp_helper),
                        style = gray20Bold
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.LightGray,
                    containerColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                        viewModel.verifyOTPAndLogin()
                    }
                )
            )
        }
    }
}