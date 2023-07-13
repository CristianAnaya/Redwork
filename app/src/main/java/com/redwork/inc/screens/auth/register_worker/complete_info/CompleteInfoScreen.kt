package com.redwork.inc.screens.auth.register_worker.complete_info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.register_worker.complete_info.components.CompleteInfoContent

@Composable
fun CompleteInfoScreen(navController: NavHostController) {
    Scaffold(
        containerColor = Color.White
    ) {
        CompleteInfoContent(
            paddingValues = it,
            navHostController = navController
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CompleteInfoScreenPreview() {
    CompleteInfoScreen(rememberNavController())
}