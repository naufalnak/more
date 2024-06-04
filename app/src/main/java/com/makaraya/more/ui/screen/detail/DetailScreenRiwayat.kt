package com.makaraya.more.screen.detailriwayat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.makaraya.more.R
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun DetailRiwayatTopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {
                navController.navigate(Screen.Riwayat.route)
            },
            modifier = Modifier
                .padding(start = 2.dp, end = 10.dp)
                .size(30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.menu_riwayat),
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Detail Riwayat",
            fontSize = 20.sp, fontFamily = Montserrat.Bold,
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenRiwayat(
    navController: NavController,
) {
    var rating by remember { mutableStateOf(4) }
    var ulasan by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(if (isSystemInDarkTheme())Color.DarkGray else Color.White)
    ) {
        DetailRiwayatTopBar(navController = navController)

        Text("Berhasil", fontSize = 18.sp, fontFamily = Montserrat.Bold , modifier = Modifier.padding(bottom = 8.dp))

        DetailItem(label = "Tanggal", value = "04 Mei 2024")
        DetailItem(label = "Waktu", value = "15.00")
        DetailItem(label = "Tipe Pemesanan", value = "Reservasi Jadwal")
        DetailItem(label = "Jenis Kendaraan", value = "Sepeda Motor")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Rincian Layanan", fontSize = 18.sp,fontFamily = Montserrat.Bold , modifier = Modifier.padding(bottom = 8.dp))
        DetailItem(label = "Ganti Oli Sampingan", value = "Rp 58.300")
        DetailItem(label = "Biaya Layanan", value = "Rp 1.000")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Detail Pembayaran", fontSize = 18.sp,fontFamily = Montserrat.Bold , modifier = Modifier.padding(bottom = 8.dp))
        DetailItem(label = "Metode Pembayaran", value = "Transfer Bank BNI")
        DetailItem(label = "Total Bayar", value = "Rp 59.300")

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Bagaimana Layanan Bengkel?", fontSize = 18.sp,fontFamily = Montserrat.Bold , modifier = Modifier.padding(bottom = 8.dp))

        RatingBar(rating = rating, onRatingChanged = { rating = it })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value =  ulasan,
            onValueChange = { ulasan = it },
            placeholder = {
                androidx.compose.material3.Text(
                    text = "Ketik alasannya disini...",
                    fontFamily = Montserrat.Regular ,fontSize = 16.sp
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(100.dp)
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        androidx.compose.material3.Button(
            onClick = { /*TODO*/},
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#1D4371"))
            )
        ) {
            androidx.compose.material3.Text(
                text = "Simpan",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Montserrat.SemiBold
                ),
            )
        }
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 16.sp, fontFamily = Montserrat.Regular )
        Text(value, fontSize = 16.sp)
    }
}


@Composable
fun RatingBar(rating: Int, onRatingChanged: (Int) -> Unit) {
    val filledStarColor = Color(0xFFF0C544)
    val emptyStarColor = Color(0xFFF0C544)

    Row {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating) Icons.Default.Star else Icons.Default.StarBorder,
                contentDescription = null,
                tint = if (i <= rating) Color(0xFFF0C544) else Color(0xFFF0C544),
                modifier = Modifier
                    .size(37.dp)
                    .clickable { onRatingChanged(i) }
                    .padding()
            )
        }
    }
}

@Preview
@Composable
fun PreviewDetailScreenRiwayat() {
    DetailScreenRiwayat(navController = rememberNavController())
}