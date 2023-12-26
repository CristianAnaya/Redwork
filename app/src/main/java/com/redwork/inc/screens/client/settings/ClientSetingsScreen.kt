package com.redwork.inc.screens.client.settings

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.R
import com.redwork.inc.components.DefaultTopBar
import com.redwork.inc.screens.client.settings.components.ClientSettingsContent

@Composable
fun ClientSettingsScreen(
    navController: NavHostController
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            DefaultTopBar(
                title = stringResource(id = R.string.client_profile),
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        ClientSettingsContent(paddingValues = it)
    }

}
