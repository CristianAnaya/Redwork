package com.redwork.inc.screens.auth.register_client

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.components.DefaultTopBar
import com.redwork.inc.screens.auth.register_client.components.RegisterClient
import com.redwork.inc.screens.auth.register_client.components.RegisterClientContent

@Composable
fun RegisterClientScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        RegisterClientContent(paddingValues = it)
    }
    RegisterClient(navController = navController)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterClientScreenPreview() {
    RegisterClientScreen(rememberNavController())
}