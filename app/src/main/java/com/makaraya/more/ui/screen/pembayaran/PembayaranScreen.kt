package com.makaraya.more.ui.screen.pembayaran

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.R
import com.makaraya.more.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PembayaranScreen(
    navController: NavController,
) {
    val selectedPaymentMethod = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp),
                ) {
                    Image(
                        painterResource(id = R.drawable.iconmore),
                        contentDescription = "Icon",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Column {
                        Text(
                            text = "Bengkel A",
                            modifier = Modifier.padding(start = 8.dp),
                            style = TextStyle(
                                fontFamily = Montserrat.Medium,
                                fontSize = 14.sp,
                            ),
                        )
                        Text(
                            text = "Jl. Gatot Subroto No. 52 Bantul, Yogyakarta",
                            modifier = Modifier.padding(start = 8.dp),
                            style = TextStyle(
                                fontFamily = Montserrat.Regular,
                                fontSize = 10.sp,
                            ),

                            )
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.calendar_clock),
                    contentDescription = "Icon",
                    modifier = Modifier.size(30.dp),
                    colorFilter = ColorFilter.tint(Color(0xFF1D4371))
                )
                Spacer(modifier = Modifier.padding(start = 8.dp))
                Text(
                    text = "4 Mei 2024",
                    modifier = Modifier.padding(start = 8.dp),
                    style = TextStyle(
                        fontFamily = Montserrat.Medium,
                        fontSize = 14.sp,
                    )
                )
            }
        }
        Text(
            text = "Jenis Kendaraan",
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Spacer(modifier = Modifier.padding(start = 8.dp))
            }
        }

        Text(
            text = "Rincian Layanan",
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {

            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.receipt),
                    contentDescription = "Icon",
                    modifier = Modifier.size(30.dp),
                    colorFilter = ColorFilter.tint(Color(0xFF1D4371))
                )
                Spacer(modifier = Modifier.padding(start = 8.dp))
                Text(
                    text = "Total Bayar",
                    modifier = Modifier.padding(start = 8.dp),
                    style = TextStyle(
                        fontFamily = Montserrat.Medium,
                        fontSize = 14.sp,
                    )
                )
            }
        }


        Text(
            text = "Pilih Pembayaran",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 12.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(id = R.drawable.money),
                        contentDescription = "Icon",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text(
                        text = "Cash",
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedPaymentMethod.value == "Cash",
                        onClick = { selectedPaymentMethod.value = "Cash" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF1D4371),
                            unselectedColor = Color(0xFF1D4371)
                        )
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(id = R.drawable.account),
                        contentDescription = "Icon",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text(
                        text = "Transfer Bank",
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedPaymentMethod.value == "Transfer Bank",
                        onClick = { selectedPaymentMethod.value = "Transfer Bank" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF1D4371),
                            unselectedColor = Color(0xFF1D4371)
                        )
                    )
                }
                if (selectedPaymentMethod.value == "Transfer Bank") {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.padding(start = 40.dp))
                        Text(
                            text = "Bank BNI",
                            modifier = Modifier.padding(
                                start = 8.dp,
                                bottom = 8.dp
                            )
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.padding(start = 40.dp))
                        Text(
                            text = "No Rekening:",
                            style = TextStyle(
                                fontFamily = Montserrat.Medium,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(
                                start = 8.dp,
                                bottom = 8.dp
                            )
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.padding(start = 40.dp))
                        Text(
                            text = "1234567890",
                            style = TextStyle(
                                fontFamily = Montserrat.Medium,
                                fontSize = 14.sp,
                                color = Color.Blue
                            ),
                            modifier = Modifier
                                .padding(
                                    start = 8.dp,
                                    bottom = 8.dp
                                )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "SALIN",
                            style = TextStyle(
                                fontFamily = Montserrat.Medium,
                                fontSize = 14.sp,
                                color = Color.Blue
                            ),
                            modifier = Modifier
                                .padding(end = 8.dp, bottom = 8.dp)
                                .clickable {},
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.padding(start = 40.dp))
                        Text(
                            text = "Bayar pesanan ke Nomor Rekening di atas.",
                            style = TextStyle(
                                fontFamily = Montserrat.Regular,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier.padding(
                                start = 8.dp,
                                bottom = 12.dp
                            )
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(id = R.drawable.qris),
                        contentDescription = "Icon",
                        modifier = Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF1D4371))
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text(
                        text = "QRIS",
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedPaymentMethod.value == "QRIS",
                        onClick = { selectedPaymentMethod.value = "QRIS" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF1D4371),
                            unselectedColor = Color(0xFF1D4371)
                        )
                    )
                }
            }
        }

        Button(
            onClick = { /* Handle reservation submission */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1D4371)
            )
        ) {
            Text(text = "Bayar Sekarang")
        }
    }
}

@Preview
@Composable
fun PreviewPembayaranScreen() {
//    PembayaranScreen()
}
