import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.R
import com.makaraya.more.model.ServiceOption
import com.makaraya.more.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationScreen() {
    val serviceOptions = remember {
        listOf(
            ServiceOption("Ganti Ban Motor", "200.000"),
            ServiceOption("Ganti Oli Sampingan", "58.300"),
            ServiceOption("Tune Up Motor Injeksi", "82.500"),
            ServiceOption("Ganti Busi Motor", "57.500"),
            ServiceOption("Pembersihan Saringan Udara", "30.000")
        )
    }

    val selectedOptions = remember { mutableStateListOf<Boolean>() }
    for (i in serviceOptions.indices) {
        selectedOptions.add(false)
    }

    var selectedVehicle by remember { mutableStateOf("") }

    val list = listOf("09.00", "09.30", "10.00", "10.30", "11.00", "11.30")

    var selectedText by remember {
        mutableStateOf("Pilih waktu")
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            Text(
                text = "Butuh Mekanik Datang ke Lokasi Anda? Klik Ganti",
                style = TextStyle(
                    fontSize = 12.sp
                )
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
                    Image(
                        painterResource(id = R.drawable.calendar_clock),
                        contentDescription = "Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text(
                        text = "Reservasi Jadwal",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ClickableText(
                        text = AnnotatedString("Ganti"),
                        onClick = {},
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }
            }
            Text(
                text = "Tanggal",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Montserrat.SemiBold
                ),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )

            Text(
                text = "Waktu",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Montserrat.SemiBold
                ),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = { isExpanded = !isExpanded },
                modifier = Modifier
                    .padding(8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    value = selectedText,
                    onValueChange = {},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp),
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
                )

                ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                    list.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                selectedText = list[index]
                                isExpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }

                }
            }

            Text(
                text = "Jenis Kendaraan",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 12.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 40.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Sepeda Motor",
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        androidx.compose.material3.RadioButton(
                            selected = selectedVehicle == "Sepeda Motor",
                            onClick = {selectedVehicle = "Sepeda Motor"},
                            colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Mobil",
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        androidx.compose.material3.RadioButton(
                            selected = selectedVehicle == "Mobil",
                            onClick = {selectedVehicle = "Mobil"},
                            colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                        )
                    }
                }
            }

            Text(
                text = "Pilihan Layanan",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 12.dp)
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 40.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    for ((index, option) in serviceOptions.withIndex()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = selectedOptions[index],
                                onCheckedChange = { isChecked ->
                                    selectedOptions[index] = isChecked
                                }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = option.name,
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .padding(start = 8.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = option.price,
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .padding(start = 8.dp)
                            )
                        }
                    }
                }
            }
            Button(
                onClick = { /* Handle reservation submission */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1D4371)
                )
            ) {
                Text(text = "Konfirmasi")
            }
        }
    }
}

@Preview
@Composable
fun PreviewReservationScreen() {
    ReservationScreen()
}
