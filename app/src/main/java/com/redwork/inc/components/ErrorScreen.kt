package com.redwork.inc.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redwork.domain.core.UiText

@Composable
fun ErrorScreen(message: UiText) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ErrorMessage(uiText = message)
    }
}
@Composable
fun ErrorMessage(uiText: UiText) {
    Text(
        text = asString(uiText = uiText),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun asString(uiText: UiText): String {
    return when(uiText) {
        is UiText.DynamicString -> uiText.value
        is UiText.StringResource -> stringResource(uiText.id, uiText.args)
    }
}
