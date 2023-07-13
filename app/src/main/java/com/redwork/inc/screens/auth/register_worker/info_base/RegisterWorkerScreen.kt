package com.redwork.inc.screens.auth.register_worker.info_base

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.redwork.inc.screens.auth.register_worker.info_base.components.RegisterWorker
import com.redwork.inc.screens.auth.register_worker.info_base.components.RegisterWorkerContent

@Composable
fun RegisterWorkerScreen(navController: NavHostController) {
    Scaffold() {
        RegisterWorkerContent(paddingValues = it)
    }

    RegisterWorker(navController = navController)
}