package com.makaraya.more.screen.riwayat.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.model.Riwayat
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun PanggilMekanikItem(
    riwayat: Riwayat,
    modifier: Modifier = Modifier,
) {
    Box (
        modifier = modifier
    ){
        Card (
            modifier = Modifier
                .width(373.dp)
                .height(200.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            ),
            border = BorderStroke(2.dp, Color(0xFF54718B)),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Text(
                text = riwayat.namaBengkel,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = Montserrat.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Divider(
                modifier = Modifier.padding(top = 16.dp),
                color = Color(0xFF54718B),
                thickness = 2.dp
            )
            Column (
                modifier = Modifier.padding(start = 16.dp)
            ){
                Spacer(modifier = modifier.padding(top= 10.dp))
                Text(
                    text = riwayat.jenisKendaraan,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Montserrat.Medium
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = modifier.padding(bottom = 10.dp))
                Text(
                    text = riwayat.tanggal,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Montserrat.Medium
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = modifier.padding(bottom = 20.dp))
                Text(
                    text = "Kendala Kendaraan",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Montserrat.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = modifier.padding(bottom = 10.dp))
                Text(
                    text = riwayat.KendalaKendaraan,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Montserrat.Medium
                    ),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PanggilMekanikItemPrev() {
    MORETheme {
        PanggilMekanikItem(
            riwayat = Riwayat(
                1,
                "Bengkel Anugrah",
                "Sepeda Motor",
                "04 Mei 2024",
                "Mobil mengeluarkan asap putih dari kap mesin",
                "Rp 58.300"
            )
        )
    }
}