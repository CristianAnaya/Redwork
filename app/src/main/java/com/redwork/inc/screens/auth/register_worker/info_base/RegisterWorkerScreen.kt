package com.redwork.inc.screens.auth.register_worker.info_base

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.register_worker.info_base.components.RegisterWorker
import com.redwork.inc.screens.auth.register_worker.info_base.components.RegisterWorkerContent
import com.redwork.inc.screens.auth.roles.RolesScreen

@Composable
fun RegisterWorkerScreen(
    navController: NavHostController,
) {
    Scaffold() {
        RegisterWorkerContent(paddingValues = it)
    }
    RegisterWorker(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterWorkerScreenPreview() {
    RegisterWorkerScreen(rememberNavController())
}