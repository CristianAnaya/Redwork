package com.redwork.co.screens.auth.login.component

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redwork.co.R
import com.redwork.co.components.SizedBox
import com.redwork.co.screens.auth.login.LoginViewModel
import com.redwork.co.screens.auth.login.widget.CountryCodePicker
import com.redwork.co.screens.auth.login.widget.OTPComposable
import com.redwork.co.ui.theme.black20Bold
import com.redwork.co.ui.theme.gray20Bold
import com.redwork.co.ui.theme.white20Bold


/**
 * The authentication view which will be used to give the user an option to authenticate
 * themselves and start using the application.
 *
 * Will be using phone number login to authenticate the user. This will be similar to WhatsApp.
 *
 * [viewModel] will be used to do all the business logic and update the view
 * state when required.
 */

@Composable
fun LoginContent(
    paddingValues: PaddingValues,
    formFill: () -> Unit,
    home: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 30.dp)
        ) {
            Text(
                stringResource(id = R.string.insert_phone_number),
                style = MaterialTheme.typography.bodyLarge
            )
            SizedBox(
                sizeFloat = 0.1f
            )
            TextField(
                value = viewModel.phone,
                textStyle = black20Bold,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                onValueChange = { viewModel.onPhoneInput(it) },
                placeholder = {
                    Text(
                        stringResource(id = R.string.phone_helper),
                        style = gray20Bold
                    )
                },
                leadingIcon = {
                    Row {
                        CountryCodePicker(pickedCountry = {
                            viewModel.country = it
                        })
                        SizedBox(width = 10)
                    }
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
                        if (context is Activity) {
                            //authenticationViewModel.sendOTPToPhoneNumber(context)
                        }
                    }
                )
            )
            OTPComposable(
                home = home,
                formFill = formFill
            )
            SizedBox(height = 50)
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                onClick = {
                    focusManager.clearFocus()
                    if (context is Activity) {
                        if (viewModel.otpSent) {
                            //authenticationViewModel.verifyOTP(context, home, formFill)
                        } else {
                           // authenticationViewModel.sendOTPToPhoneNumber(context)
                        }
                    }
                }
            ) {
                Text(
                    if (viewModel.otpSent)
                        stringResource(id = R.string.verify).uppercase()
                    else
                        stringResource(id = R.string.continue_button).uppercase(),
                    style = white20Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}