package com.redwork.inc.screens.auth.register_worker.complete_info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.register_worker.complete_info.components.CompleteInfoContent
import com.redwork.inc.screens.auth.register_worker.complete_info.components.SaveInfoWorker

@Composable
fun CompleteInfoScreen(
    navController: NavHostController,
    viewModel: CompleteInfoViewModel = hiltViewModel()
) {
    viewModel.getSessionData()
    viewModel.getSelectedCategories()
    viewModel.getSelectedAddress()

    Scaffold(
        containerColor = Color.White
    ) {
        CompleteInfoContent(
            paddingValues = it,
            navController = navController
        )
    }
    
    SaveInfoWorker(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CompleteInfoScreenPreview() {
    CompleteInfoScreen(rememberNavController())
}