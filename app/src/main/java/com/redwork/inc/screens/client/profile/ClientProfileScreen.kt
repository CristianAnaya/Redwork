package com.redwork.inc.screens.client.profile

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.components.DefaultTopBar
import com.redwork.inc.screens.client.profile.components.ClientProfileContent

@Composable
fun ClientProfileScreen(
    navController: NavHostController
) {
    Scaffold(
        containerColor = Color.White
    ) {
        ClientProfileContent(paddingValues = it)
    }
}