package com.redwork.inc.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.redwork.inc.R

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
    fontSize = 20.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val black20 = TextStyle(
    color = Black,
    fontSize = 20.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family

)

val black20Bold = TextStyle(
    color = Black,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val black15Bold = TextStyle(
    color = Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold,
)

val black20Medium = TextStyle(
    color = Black,
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium,
    fontFamily = poppins_family
)

val black15Medium = TextStyle(
    color = Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Medium,
)


val black13Medium = TextStyle(
    color = Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Medium,
    fontFamily = poppins_family
)

val black15Light = TextStyle(
    color = Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Light,
    fontFamily = poppins_family
)

val orange20Bold = TextStyle(
    color = Orange,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val orange15Bold = TextStyle(
    color = Orange,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val orange13Bold60 = TextStyle(
    color = Orange.copy(alpha = 0.6f),
    fontSize = 13.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val orange13Bold = TextStyle(
    color = Orange,
    fontSize = 13.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val orange20Light = TextStyle(
    color = Orange,
    fontSize = 20.sp,
    fontWeight = FontWeight.Light,
    fontFamily = poppins_family
)

val orange15Light = TextStyle(
    color = Orange,
    fontSize = 15.sp,
    fontWeight = FontWeight.Light,
    fontFamily = poppins_family
)

val orange13Light = TextStyle(
    color = Orange,
    fontSize = 13.sp,
    fontWeight = FontWeight.Light,
    fontFamily = poppins_family
)

val orange20Normal = TextStyle(
    color = Orange,
    fontSize = 20.sp,
    fontWeight = FontWeight.Light,
    fontFamily = poppins_family
)

val orange15Normal = TextStyle(
    color = Orange,
    fontSize = 15.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val orange13Normal = TextStyle(
    color = Orange,
    fontSize = 13.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val black12 = TextStyle(
    color = Black,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val black15 = TextStyle(
    color = Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val gray15 = TextStyle(
    color = Color.Gray,
    fontSize = 15.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val gray12Italic = TextStyle(
    color = Color.Gray,
    fontSize = 15.sp,
    fontStyle = FontStyle.Italic,
    fontFamily = poppins_family
)

val gray20Bold = TextStyle(
    color = Color.Gray,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val gray15Bold = TextStyle(
    color = Color.Gray,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)


val white20Bold = TextStyle(
    color = Color.White,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val white25Bold = TextStyle(
    color = Color.White,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val white15Bold = TextStyle(
    color = Color.White,
    fontSize = 15.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val white20Bold60 = TextStyle(
    color = Color.White.copy(alpha = 0.6f),
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)

val link15 = TextStyle(
    color = Color.Blue,
    fontSize = 20.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = poppins_family
)

val lightGray15 = TextStyle(
    color = Color.LightGray,
    fontSize = 15.sp,
    fontFamily = poppins_family
)

val lightGray20 = TextStyle(
    color = Color.LightGray,
    fontSize = 20.sp,
    fontWeight = FontWeight.Light,
    fontFamily = poppins_family
)

val red30Bold = TextStyle(
    color = Color.Red,
    fontSize = 30.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = poppins_family
)
