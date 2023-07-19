package com.redwork.inc.screens.auth.register_worker.select_address.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.redwork.domain.core.Resource
import com.redwork.inc.R.string.saving
import com.redwork.inc.components.CircularIndicator
import com.redwork.inc.components.asString
import com.redwork.inc.screens.auth.register_worker.select_address.SelectAddressViewModel
import com.redwork.inc.screens.auth.register_worker.selected_category.SelectedCategoryViewModel

@Composable
fun SaveSelectedAddress(
    navController: NavHostController,
    viewModel: SelectAddressViewModel = hiltViewModel()
) {
    when(val response = viewModel.saveSelectedAddressResource) {
        is Resource.Loading -> {
            CircularIndicator(stringResource(id = saving))
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.popBackStack()
            }
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