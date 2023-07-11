package com.redwork.inc.screens.auth.roles.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.redwork.inc.R.drawable.person_register
import com.redwork.inc.R.string.choose_role
import com.redwork.inc.R.string.choose_role_client
import com.redwork.inc.R.string.choose_role_worker
import com.redwork.inc.R.string.we_verify_your_number
import com.redwork.inc.components.DefaultButton
import com.redwork.inc.components.SizedBox
import com.redwork.inc.ui.theme.Orange
import com.redwork.inc.ui.theme.PrimaryLight
import com.redwork.inc.ui.theme.black15Light
import com.redwork.inc.ui.theme.black20Bold
import com.redwork.inc.ui.theme.white20Bold

@Composable
fun RolesContent(paddingValues: PaddingValues, navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(
                width = 180.dp,
                height = 180.dp
            ),
            painter = painterResource(id = person_register),
            contentDescription = ""
        )

        SizedBox(height = 30)

        Text(
            text = stringResource(id = we_verify_your_number),
            style = black20Bold
        )

        SizedBox(height = 40)

        Text(
            text = stringResource(id = choose_role),
            style = black15Light
        )


        Spacer(modifier = Modifier.weight(1f))

        DefaultButton(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),
            text = stringResource(id = choose_role_client),
            style = white20Bold,
            color = Orange,
            onClick = { /*TODO*/ }
        )

        DefaultButton(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),
            text = stringResource(id = choose_role_worker),
            style = white20Bold,
            color = PrimaryLight,
            onClick = { /*TODO*/ }
        )
        
        Spacer(modifier = Modifier.padding(bottom = 100.dp))
    }
}
