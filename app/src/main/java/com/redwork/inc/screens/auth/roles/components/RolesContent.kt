package com.redwork.inc.screens.auth.roles.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.components.SizedBox
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.ui.theme.black12
import com.redwork.inc.ui.theme.black15
import com.redwork.inc.ui.theme.black20Bold

@Composable
fun RolesContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    phone: String?
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = stringResource(id = R.string.tell_us_who_you_are),
            style = black20Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            navController.navigate(
                                route = AuthScreen.RegisterClient.passRole(
                                    "CLIENT",
                                    phone ?: ""
                                )
                            )
                        },
                    painter = painterResource(id = R.drawable.icon_client),
                    contentDescription = ""
                )

                SizedBox(height = 10)

                Text(
                    text = stringResource(id = R.string.choose_role_client),
                    style = black15
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            navController.navigate(
                                route = AuthScreen.RegisterClient.passRole(
                                    "WORKER",
                                    phone ?: ""
                                )
                            )
                        },
                    painter = painterResource(id = R.drawable.icon_worker),
                    contentDescription = ""
                )

                SizedBox(height = 10)

                Text(
                    text = stringResource(id = R.string.choose_role_worker),
                    style = black15
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .padding(start = 5.dp, bottom = 5.dp)
                .align(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.decide_client_or_professional),
                contentDescription = ""
            )

            SizedBox(width = 5)

            Text(
                text = stringResource(id = R.string.decide_your_are_professional_or_client),
                style = black12
            )
        }

    }
}

//Image(
//            modifier = Modifier.size(
//                width = 180.dp,
//                height = 180.dp
//            ),
//            painter = painterResource(id = person_register),
//            contentDescription = ""
//        )
//
//        SizedBox(height = 30)
//
//        Text(
//            text = stringResource(id = we_verify_your_number),
//            style = black20Bold
//        )
//
//        SizedBox(height = 40)
//
//        Text(
//            text = stringResource(id = choose_role),
//            style = black15Light
//        )
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        DefaultButton(
//            modifier = Modifier
//                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
//                .fillMaxWidth(),
//            text = stringResource(id = choose_role_client),
//            style = white20Bold,
//            color = Orange,
//            onClick = { navController.navigate(route = AuthScreen.RegisterClient.passRole("CLIENT", phone ?: "")) }
//        )
//
//        DefaultButton(
//            modifier = Modifier
//                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
//                .fillMaxWidth(),
//            text = stringResource(id = choose_role_worker),
//            style = white20Bold,
//            color = PrimaryLight,
//            onClick = { navController.navigate(route = AuthScreen.RegisterWorker.passRole("WORKER", phone ?: "")) }
//        )
//
//        Spacer(modifier = Modifier.padding(bottom = 100.dp))
