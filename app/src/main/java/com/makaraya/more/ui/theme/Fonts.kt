package com.makaraya.more.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.makaraya.more.R

object Montserrat {
    val Regular = FontFamily(
        Font(R.font.montserrat_regular, FontWeight.Normal)
    )

    val Italic = FontFamily(
        Font(R.font.montserrat_italic, FontWeight.Normal, FontStyle.Italic)
    )

    val Bold = FontFamily(
        Font(R.font.montserrat_bold, FontWeight.Bold)
    )

    val SemiBold = FontFamily(
        Font(R.font.montserrat_semibold, FontWeight.SemiBold)
    )
    val Medium = FontFamily(
        Font(R.font.montserrat_medium, FontWeight.Normal)
    )

    val Light = FontFamily(
        Font(R.font.montserrat_light, FontWeight.Light)
    )
}