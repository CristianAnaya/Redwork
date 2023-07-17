package com.redwork.inc.screens.auth.register_worker.select_address

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.components.DefaultTopBar
import com.redwork.inc.screens.auth.register_worker.select_address.components.SelectAddressContent

@Composable
fun SelectAddressScreen(navController: NavHostController) {

    Scaffold(
        containerColor = Color.White,
        topBar = {
            DefaultTopBar(
                title = stringResource(id = R.string.select_location),
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        SelectAddressContent(it)
    }

}