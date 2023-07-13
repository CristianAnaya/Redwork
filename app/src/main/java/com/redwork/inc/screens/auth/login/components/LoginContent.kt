package com.redwork.inc.screens.auth.login.components

import TogiCodeDialog
import android.app.Activity
import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.redwork.inc.R
import com.redwork.inc.components.SizedBox
import com.redwork.inc.components.country_code.data.utils.getDefaultLangCode
import com.redwork.inc.components.country_code.data.utils.getDefaultPhoneCode
import com.redwork.inc.components.country_code.data.utils.getLibCountries
import com.redwork.inc.screens.auth.login.LoginViewModel
import com.redwork.inc.screens.auth.login.widget.OTPComposable
import com.redwork.inc.ui.theme.black15
import com.redwork.inc.ui.theme.gray15
import com.redwork.inc.ui.theme.white15Bold


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
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var phoneCode by rememberSaveable {
        mutableStateOf(
            getDefaultPhoneCode(
                context
            )
        )
    }

    val defaultLang by rememberSaveable {
        mutableStateOf(
            getDefaultLangCode(context)
        )
    }

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
                stringResource(id = R.string.enter_phone_number),
                style = MaterialTheme.typography.bodyLarge
            )
            SizedBox(
                sizeFloat = 0.1f
            )
            TextField(
                value = state.phone,
                textStyle = black15,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                onValueChange = { viewModel.onPhoneInput(it) },
                placeholder = {
                    Text(
                        stringResource(id = R.string.phone_helper),
                        style = gray15
                    )
                },
                leadingIcon = {
                    Row {
                        TogiCodeDialog(
                            pickedCountry = {
                                viewModel.onCountryInput(it.countryPhoneCode)
                            },
                            defaultSelectedCountry = getLibCountries.single { it.countryCode == defaultLang },
                            showCountryCode = true,
                            showFlag = true,
                            showCountryName = false
                        )
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
                            viewModel.sendOTPToPhoneNumber(context)
                        }
                    }
                )
            )
            OTPComposable()
            SizedBox(height = 50)
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50),
                onClick = {
                    focusManager.clearFocus()
                    if (state.validationId.isNotEmpty()) {
                        viewModel.verifyOTPAndLogin()
                    } else {
                        if (context is Activity) {
                            viewModel.sendOTPToPhoneNumber(context)
                        }
                    }
                }
            ) {
                Text(
                    if (state.validationId.isNotEmpty())
                        stringResource(id = R.string.verify).uppercase()
                    else
                        stringResource(id = R.string.continue_button).uppercase(),
                    style = white15Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}