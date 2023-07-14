package com.redwork.inc.screens.auth.register_worker.selected_category

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.R.string.selecte_category
import com.redwork.inc.components.DefaultTopBar
import com.redwork.inc.screens.auth.register_worker.selected_category.components.GetCategoriesWithServices
import com.redwork.inc.screens.auth.register_worker.selected_category.components.SaveSelectedCategories
import com.redwork.inc.screens.auth.register_worker.selected_category.components.SelectedCategoryContent

@Composable
fun SelectedCategoryScreen(
    navController: NavHostController,
    viewModel: SelectedCategoryViewModel = hiltViewModel()
) {

    viewModel.getCategories()

    Scaffold(
        containerColor = Color.White,
        topBar = {
            DefaultTopBar(
                title = stringResource(id = selecte_category),
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        GetCategoriesWithServices(it)
    }

    SaveSelectedCategories(navController = navController)
}