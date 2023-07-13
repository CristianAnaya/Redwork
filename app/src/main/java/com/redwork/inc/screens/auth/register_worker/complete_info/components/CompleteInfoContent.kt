package com.redwork.inc.screens.auth.register_worker.complete_info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.components.DefaultButton
import com.redwork.inc.components.SizedBox
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.ui.theme.black13Medium
import com.redwork.inc.ui.theme.black15
import com.redwork.inc.ui.theme.orange13Bold60
import com.redwork.inc.ui.theme.orange15Bold
import com.redwork.inc.ui.theme.orange15Normal
import com.redwork.inc.ui.theme.white20Bold

@Composable
fun CompleteInfoContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController
) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 40.dp)
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.hello_helper),
                style = orange15Normal
            )

            SizedBox(width = 3)

            Text(
                text = "Cristian Anaya",
                style = orange15Bold
            )
        }

        SizedBox(height = 10)

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.Start)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.we_want_know_to_what_dedication),
                style = black15
            )

            SizedBox(height = 14)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = "",
                    textStyle = black13Medium,
                    modifier = Modifier.weight(1f),
                    onValueChange = { },
                    placeholder = {
                        Text(
                            stringResource(id = R.string.describe_your_experience),
                            style = orange13Bold60
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )


                Image(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.icon_describe_experience),
                    contentDescription = "",
                )
            }

            SizedBox(height = 8)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = "",
                    textStyle = black13Medium,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { navHostController.navigate(route = AuthScreen.SelectedCategory.route) },
                    singleLine = true,
                    onValueChange = { },
                    placeholder = {
                        Text(
                            stringResource(id = R.string.category),
                            style = orange13Bold60
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )

                Image(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.icon_add_category),
                    contentDescription = "",
                )
            }

            SizedBox(height = 8)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = "",
                    textStyle = black13Medium,
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    onValueChange = { },
                    placeholder = {
                        Text(
                            stringResource(id = R.string.location),
                            style = orange13Bold60
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )

                Image(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.icon_location),
                    contentDescription = "",
                )
            }


        }

        Spacer(modifier = Modifier.weight(1f))

        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = stringResource(id = R.string.enter_to_redwork),
            style = white20Bold,
            roundedCornerValue = 50,
            onClick = { /*TODO*/ }
        )
    }
}