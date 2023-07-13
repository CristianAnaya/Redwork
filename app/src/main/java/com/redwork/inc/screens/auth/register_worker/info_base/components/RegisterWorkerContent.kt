package com.redwork.inc.screens.auth.register_worker.info_base.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redwork.inc.R
import com.redwork.inc.R.string.account_created
import com.redwork.inc.R.string.account_created_helper
import com.redwork.inc.R.string.email
import com.redwork.inc.R.string.email_helper
import com.redwork.inc.R.string.enter_lastname
import com.redwork.inc.R.string.lastname
import com.redwork.inc.R.string.name
import com.redwork.inc.R.string.name_helper
import com.redwork.inc.components.DefaultButton
import com.redwork.inc.components.SizedBox
import com.redwork.inc.screens.auth.register_client.RegisterClientViewModel
import com.redwork.inc.ui.theme.black15
import com.redwork.inc.ui.theme.gray12Italic
import com.redwork.inc.ui.theme.gray15
import com.redwork.inc.ui.theme.white20Bold

@Composable
fun RegisterWorkerContent(
    paddingValues: PaddingValues,
    viewModel: RegisterClientViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    val state = viewModel.state

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 30.dp)
        ) {
            item {
                Text(
                    stringResource(id = account_created),
                    style = black15
                )
                Text(
                    stringResource(id = account_created_helper),
                    style = gray15
                )
                SizedBox(
                    height = 20
                )
                OutlinedTextField(
                    value = state.name,
                    textStyle = black15,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    onValueChange = { viewModel.onNameInput(it) },
                    placeholder = {
                        Text(
                            stringResource(id = name_helper),
                            style = gray15
                        )
                    },
                    label = {
                        Text(
                            stringResource(id = name),
                            style = gray15
                        ) },
                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.LightGray,
                            containerColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done,
                            capitalization = KeyboardCapitalization.Words
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        )
                )
                SizedBox(height = 15)
                OutlinedTextField(
                    value = state.lastname,
                    textStyle = black15,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    onValueChange = { viewModel.onLastnameInput(it) },
                    placeholder = {
                        Text(
                            stringResource(id = enter_lastname),
                            style = gray15
                        )
                    },
                    label = {
                        Text(
                            stringResource(id = lastname),
                            style = gray15
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )
                SizedBox(height = 15)
                OutlinedTextField(
                    value = state.email,
                    textStyle = black15,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    onValueChange = { viewModel.onEmailInput(it) },
                    placeholder = {
                        Text(
                            stringResource(id = email_helper),
                            style = gray15
                        )
                    },
                    label = {
                        Text(
                            stringResource(id = email),
                            style = gray15
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                    )
                    SizedBox(height = 5)
                    Text(
                        text = stringResource(id = R.string.email_note),
                        style = gray12Italic
                    )

                    SizedBox(height = 50)

                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.save_information),
                        style = white20Bold,
                        roundedCornerValue = 50,
                        onClick = {
                            focusManager.clearFocus()
                            viewModel.register()
                        }
                    )
            }
        }
    }
}
