package dev.tsnanh.android.spotifyclone.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.tsnanh.android.spotifyclone.R

val GothamFontFamily = FontFamily(
    Font(R.font.gotham_regular, weight = FontWeight.Normal),
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    defaultFontFamily = GothamFontFamily,
    h1 = TextStyle(
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold,
    ),
    h2 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
    ),
    h3 = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
    ),
    h4 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
    ),
    subtitle1 = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal,
        color = Color.LightGray,
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Thin,
        letterSpacing = 3.sp,
        color = Color.LightGray,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
