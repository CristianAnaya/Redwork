package com.redwork.inc.screens.auth.register_worker.choose_address

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.register_worker.choose_address.components.ChooseAddressContent
import com.redwork.inc.screens.client.available_category.AvailableCategoryScreen
import com.redwork.inc.ui.theme.poppins_family

@Composable
fun ChooseAddressScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Ubicación",                        fontFamily = poppins_family)
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Rounded.Settings, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    ) {
        ChooseAddressContent(paddingValues = it, navController = navController)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChooseAddressScreenPreview() {
    ChooseAddressScreen(rememberNavController())
}