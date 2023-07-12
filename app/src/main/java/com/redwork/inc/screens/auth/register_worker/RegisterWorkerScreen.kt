package com.redwork.inc.screens.auth.register_worker

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.redwork.inc.screens.auth.register_client.components.RegisterClientContent
import com.redwork.inc.screens.auth.register_worker.components.RegisterWorkerContent

@Composable
fun RegisterWorkerScreen(navController: NavHostController) {
    Scaffold() {
        RegisterWorkerContent(paddingValues = it)
    }
}