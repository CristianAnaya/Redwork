package com.redwork.inc.screens.auth.register_worker.select_address

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.redwork.inc.screens.auth.register_worker.select_address.components.SaveSelectedAddress
import com.redwork.inc.screens.auth.register_worker.select_address.components.SelectAddressContent

@Composable
fun SelectAddressScreen(navController: NavHostController) {

    Scaffold(
        containerColor = Color.White,
    ) {
        SelectAddressContent(it, navController)
    }
    SaveSelectedAddress(navController = navController)
}