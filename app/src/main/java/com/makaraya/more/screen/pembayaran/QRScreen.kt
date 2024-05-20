package com.makaraya.more.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.R
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun QRScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Please scan a QR code",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = Montserrat.SemiBold
            ),
            modifier = Modifier.padding(bottom = 50.dp)
        )
        Text(
            text = "Scan your QR",
            style = TextStyle(
                color = Color.Black,
                fontSize = 26.sp,
                fontFamily = Montserrat.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painterResource(id = R.drawable.qr),
            contentDescription = "Icon",
            modifier = Modifier.size(350.dp)
        )
    }
}

@Preview
@Composable
fun PreviewQRScreen() {
    QRScreen()
}

