package com.redwork.inc.screens.client.available_category.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.redwork.domain.core.Resource
import com.redwork.inc.R
import com.redwork.inc.components.asString
import com.redwork.inc.screens.client.available_category.AvailableCategoryViewModel
import com.redwork.inc.ui.theme.PrimaryDark

@Composable
fun GetAvailableCategories(
    paddingValues: PaddingValues,
    viewModel: AvailableCategoryViewModel = hiltViewModel()
) {
    //viewModel.getCategories()
    when(val response = viewModel.categoriesResource) {
        is Resource.Loading -> {

        }
        is Resource.Success -> {
            AvailableCategoryContent(
                paddingValues = paddingValues,
                categories = response.data
            )
        }
        is Resource.Failure -> {
            Log.d("TAG", "GetAvailableCategories:")
            Toast.makeText(LocalContext.current, asString(uiText = response.message), Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null)
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
        }
    }

}