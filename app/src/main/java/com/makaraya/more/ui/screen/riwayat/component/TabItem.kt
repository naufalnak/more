package com.makaraya.more.ui.screen.riwayat.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun TabItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color(0xFF1D4371) else Color.Transparent
    val contentColor = if (selected) White else Color(0xFF1D4371)
    val borderColor = if (selected) Color.Transparent else Color(0xFF1D4371)

    Box(
        modifier = Modifier
            .padding(10.dp)
            .height(48.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(24.dp))
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(24.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = Montserrat.Medium,
            ),
        )
    }
}