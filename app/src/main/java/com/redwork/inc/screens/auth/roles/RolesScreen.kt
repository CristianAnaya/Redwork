package com.redwork.inc.screens.auth.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.components.DefaultTopBar
import com.redwork.inc.screens.auth.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController) {
    Scaffold(
        topBar = { DefaultTopBar(title = "Selecciona tu rol") }
    ) { paddingValues ->
        RolesContent(paddingValues, navController)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RolesScreenPreview() {
    RolesScreen(rememberNavController())
}