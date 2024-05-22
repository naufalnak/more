import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.navigation.Screen
import com.makaraya.more.screen.layanan.component.BottomSheetCompose
import com.makaraya.more.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanggilMekanikScreen(
    navController: NavController,
    modifier: Modifier = Modifier.background(if (isSystemInDarkTheme())Color.DarkGray else Color.White)
) {
    val showBottomSheet = remember { mutableStateOf(false) }

    var detailLokasi by remember { mutableStateOf("") }
    var patokan by remember { mutableStateOf("") }
    var selectedKendaraan by remember { mutableStateOf("") }
    var kendalaKendaraan by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .clickable {
                        val bengkelId = 1
                        navController.navigate("${Screen.DetailBengkel.route}/$bengkelId")
                    }
            )
            Text(
                text = "Reservasi Sesuai Jadwal Anda Klik Ganti",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = Montserrat.SemiBold
                ),
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF8AB7E1),
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text(
                        text = "Panggil Mekanik",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ClickableText(
                        text = AnnotatedString("Ganti"),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                        onClick = {navController.navigate("${Screen.Reservation.route}")},
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }
            Text(
                text = "Lokasi",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = Montserrat.SemiBold
                ),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Box(
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .clickable {
                        showBottomSheet.value = true
                    }
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                    .padding(4.dp)
            ) {
                Text(
                    text = "Isi Detail Lokasi",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.Medium
                    ),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (detailLokasi.isEmpty()) "" else "$detailLokasi",
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                )
                Text(
                    text = if (patokan.isEmpty()) "" else "($patokan)",
                    modifier = Modifier.padding(start = 2.dp, top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (showBottomSheet.value) {
                BottomSheetCompose(
                    showBottomSheet = showBottomSheet,
                    onDetailsSaved = { savedDetailLokasi, savedPatokan ->
                        detailLokasi = savedDetailLokasi
                        patokan = savedPatokan
                    }
                )
            }

            Text(
                text = "Jenis Kendaraan",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = Montserrat.SemiBold
                ),
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 40.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Sepeda Motor",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.Medium
                            ),
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedKendaraan == "Sepeda Motor",
                            onClick = { selectedKendaraan = "Sepeda Motor"},
                            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF1D4371))
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Mobil",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.Medium
                            ),
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = selectedKendaraan == "Mobil",
                            onClick = {selectedKendaraan = "Mobil"},
                            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF1D4371))
                        )
                    }
                }
            }

            Text(
                text = "Kendala Kendaraan",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = Montserrat.SemiBold
                ),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
            )

            OutlinedTextField(
                value =  kendalaKendaraan,
                onValueChange = { kendalaKendaraan = it },
                placeholder = {
                    Text(
                        text = "Masukkan Kendala Kendaraan",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.Regular
                        ),
                    )
                },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .height(100.dp)
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1D4371)
                )
            ) {
                Text(
                    text = "Konfirmasi",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPanggilMekanikScreen() {
//    PanggilMekanikScreen()
}