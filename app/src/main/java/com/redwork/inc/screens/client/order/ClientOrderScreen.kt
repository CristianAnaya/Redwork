package com.redwork.inc.screens.client.order

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ClientOrderScreen(navController: NavController) {
    Scaffold() {
        Text(
            modifier = Modifier.padding(paddingValues = it),
            text = "Screen Order"
        )
    }
}