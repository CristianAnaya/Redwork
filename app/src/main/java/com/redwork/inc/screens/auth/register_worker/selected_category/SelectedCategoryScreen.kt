package com.redwork.inc.screens.auth.register_worker.selected_category

import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.login.LoginScreen
import com.redwork.inc.screens.auth.register_worker.selected_category.components.SelectedCategoryContent

@Composable
fun SelectedCategoryScreen(navController: NavHostController) {
    Scaffold() {
        SelectedCategoryContent(
            paddingValues = it,
            navHostController = navController
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SelectedCategoryScreenPreview() {
    SelectedCategoryScreen(rememberNavController())
}