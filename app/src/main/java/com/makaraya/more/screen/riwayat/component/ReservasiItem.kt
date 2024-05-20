package com.makaraya.more.screen.riwayat.component

import android.graphics.Paint.Align
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.model.Riwayat
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun ReservasiItem(
    riwayat: Riwayat,
    modifier: Modifier = Modifier,
) {
    Box (
        modifier = modifier
    ){
        Card (
            modifier = Modifier
                .width(373.dp)
                .height(150.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            ),
            border = BorderStroke(2.dp,Color(0xFF54718B)),
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
            Row{
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = riwayat.jenisKendaraan,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.Medium
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 16.dp, top = 10.dp)
                    )
                    Text(
                        text = riwayat.tanggal,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.Medium
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 16.dp, top = 10.dp)
                    )
                }
                Column (
                    modifier = Modifier
                        .padding(top = 10.dp)
                ){
                    Card (
                        modifier = Modifier
                            .width(115.dp)
                            .height(40.dp)
                            .padding(end = 16.dp)
                        ,
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        border = BorderStroke(2.dp,Color(0xFF54718B)),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ){
                        Box (
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(start = 13.dp, top = 5.dp)
                        ){
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Total transaksi",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 10.sp,
                                        fontFamily = Montserrat.Medium,
                                    ),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = modifier.padding(bottom = 3.dp))
                                Text(
                                    text = riwayat.transaksi,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontFamily = Montserrat.Bold,
                                    ),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                    Spacer(modifier = modifier.padding(bottom = 5.dp))
                    TextButton(
                        modifier = modifier
                            .width(99.dp)
                            .height(30.dp),
                        colors = ButtonDefaults.textButtonColors(Color(0xFF1D4371)),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Lihat Detail",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 11.sp,
                                fontFamily = Montserrat.Bold,
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ReservasiItemPrev() {
    MORETheme {
        ReservasiItem(
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