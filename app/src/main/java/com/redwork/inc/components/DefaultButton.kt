package com.redwork.inc.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redwork.inc.ui.theme.PrimaryLight

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    style: TextStyle,
    onClick: () -> Unit,
    color: Color = PrimaryLight,
) {
    Button(
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(10),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = color),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            style = style
        )
    }
}
