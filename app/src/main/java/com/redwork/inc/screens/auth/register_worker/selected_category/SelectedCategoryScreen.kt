package com.redwork.inc.screens.auth.register_worker.selected_category

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.redwork.inc.screens.auth.register_worker.selected_category.components.SelectedCategoryContent

@Composable
fun SelectedCategoryScreen(navController: NavHostController) {

    Scaffold() {
        SelectedCategoryContent(paddingValues = it)
    }
}