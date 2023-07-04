package com.redwork.co.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.redwork.co.R

// Set of Material typography styles to start with

// Set of Material typography styles to start with

val poppins_family = FontFamily(listOf(
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_light, weight = FontWeight.Light)
))

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = poppins_family,
        fontWeight = FontWeight.Bold,
        lineHeight = 28.sp,
        fontSize = 28.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppins_family,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.5.sp,
        lineHeight = 28.sp,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = poppins_family,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.5.sp,
        lineHeight = 28.sp,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = poppins_family,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = poppins_family,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.4.sp
    ),
    bodySmall = TextStyle(
        fontFamily = poppins_family,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 28.sp,
    )
)

val white30Bold = TextStyle(
    color = Color.White,
    fontSize = 30.sp,
    fontWeight = FontWeight.Bold,
)

val white20 = TextStyle(
    color = Color.White,
    fontSize = 20.sp
)

val black20 = TextStyle(
    color = Color.Black,
    fontSize = 20.sp
)

val black20Bold = TextStyle(
    color = Color.Black,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
)

val black15Bold = TextStyle(
    color = Color.Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold,
)

val gray15 = TextStyle(
    color = Color.Gray,
    fontSize = 15.sp,
)

val gray12Italic = TextStyle(
    color = Color.Gray,
    fontSize = 15.sp,
    fontStyle = FontStyle.Italic
)

val black15 = TextStyle(
    color = Color.Black,
    fontSize = 15.sp,
)

val gray20Bold = TextStyle(
    color = Color.Gray,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
)

val white20Bold = TextStyle(
    color = Color.White,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
)

val white20Bold60 = TextStyle(
    color = Color.White.copy(alpha = 0.6f),
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
)

val link15 = TextStyle(
    color = Color.Blue,
    fontSize = 20.sp,
)

val lightGray15 = TextStyle(
    color = Color.LightGray,
    fontSize = 15.sp,
)

val lightGray20 = TextStyle(
    color = Color.LightGray,
    fontSize = 20.sp,
)

val red30Bold = TextStyle(
    color = Color.Red,
    fontSize = 30.sp,
    fontWeight = FontWeight.Bold
)
