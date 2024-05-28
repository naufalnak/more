package com.makaraya.more.ui.screen.verifikasi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.ui.theme.Montserrat

//@Preview
@Composable
fun VerifikasiScreen(
    navController: NavController,
) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
        ) {
            Text(
                text = "Verifikasi",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontFamily = Montserrat.Bold
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Masukkan kode OTP!",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = Montserrat.Medium
                )
            )

            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(50.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(Color(android.graphics.Color.parseColor("#8AB7E1"))),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(50.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(Color(android.graphics.Color.parseColor("#8AB7E1"))),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(50.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(Color(android.graphics.Color.parseColor("#8AB7E1"))),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(50.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(Color(android.graphics.Color.parseColor("#8AB7E1"))),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .width(50.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(Color(android.graphics.Color.parseColor("#8AB7E1"))),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(25.dp))
            Row {
                Text(
                    text = "Kode tidak terkirim?",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.Medium
                    )
                )
                Text(
                    text = "Kirim ulang",
                    style = TextStyle(
                        color = Color(android.graphics.Color.parseColor("#1D4371")),
                        fontSize = 16.sp,
                        fontFamily = Montserrat.Medium
                    ),
                    modifier = Modifier.offset(x = 5.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#1D4371"))),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .width(318.dp)
                    .height(49.dp)
            ) {
                Text(
                    text = "Verifikasi",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = Montserrat.Medium
                    )
                )
            }
        }
}
