package com.redwork.inc.screens.auth.register_worker.selected_category.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.redwork.domain.core.Resource
import com.redwork.inc.R
import com.redwork.inc.components.CircularIndicator
import com.redwork.inc.components.asString
import com.redwork.inc.screens.auth.register_worker.selected_category.SelectedCategoryViewModel

@Composable
fun GetCategoriesWithServices(
    paddingValues: PaddingValues,
    viewModel: SelectedCategoryViewModel = hiltViewModel()
) {

    when(val response = viewModel.categoriesResource) {
        is Resource.Loading -> {
            CircularIndicator(stringResource(id = R.string.loading))
        }
        is Resource.Success -> {
            SelectedCategoryContent(
                paddingValues = paddingValues,
                categories = response.data
            )
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, asString(uiText = response.message), Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null)
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
        }
    }

}