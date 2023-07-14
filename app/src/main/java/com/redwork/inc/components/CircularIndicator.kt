package com.redwork.inc.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redwork.inc.R.string.loading
import com.redwork.inc.ui.theme.Orange
import com.redwork.inc.ui.theme.black15Medium

@Composable
fun CircularIndicator(stringResource: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            CircularProgressIndicator(
                color = Orange,
                modifier = Modifier
                    .size(48.dp)
            )
            Text(
                text = stringResource,
                style = black15Medium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
