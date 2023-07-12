package com.redwork.inc.screens.auth.register_worker.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterWorkerContent(paddingValues: PaddingValues) {
    Text(
        modifier = Modifier.padding(paddingValues = paddingValues),
        text = "Screen Register"
    )
}