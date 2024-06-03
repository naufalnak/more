package com.makaraya.more.ui.screen.layanan

import ScheduleDateTextField
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.makaraya.more.R
import com.makaraya.more.data.DummyData
import com.makaraya.more.data.model.ServiceOption
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.theme.Montserrat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationScreen(
    navController: NavController
) {
    val selectedOptions = remember { mutableStateListOf<Boolean>() }
    for (i in DummyData.serviceOptions.indices) {
        selectedOptions.add(false)
    }

    var selectedVehicle by remember { mutableStateOf("") }

    var selectedText by remember {
        mutableStateOf("Pilih waktu")
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    var scheduleDate by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePicker by remember { mutableStateOf(false) }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Calendar.getInstance().apply {
                            timeInMillis = datePickerState.selectedDateMillis!!
                        }
                        scheduleDate = formatter.format(selectedDate.time)
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) { Text("Cancel") }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
        ) {
            item {
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
                    text = "Butuh Mekanik Datang ke Lokasi Anda? Klik Ganti",
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
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.SemiBold
                            ),
                            onClick = {navController.navigate("${Screen.PanggilMekanik.route}")},
                            modifier = Modifier
                                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
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
                ScheduleDateTextField(
                    value = scheduleDate,
                    placeholder = "Atur Tanggal",
                    icon = Icons.Default.DateRange,
                    onIconClick = {
                        showDatePicker = true
                    }
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
                        DummyData.waktu.forEachIndexed { index, text ->
                            DropdownMenuItem(
                                text = { Text(text = text) },
                                onClick = {
                                    selectedText = DummyData.waktu[index]
                                    isExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }

                    }
                }

                Text(
                    text = "Jenis Kendaraan",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp, top = 12.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 40.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp
                    )
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        DummyData.vehicleTypes.forEach { vehicleType ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = vehicleType,
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
                                    selected = selectedVehicle == vehicleType,
                                    onClick = { selectedVehicle = vehicleType },
                                    colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF1D4371))
                                )
                            }
                        }
                    }
                }

                // Service options selection
                Text(
                    text = "Pilihan Layanan",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp, top = 12.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 40.dp),
                    shape = RoundedCornerShape(16.dp),
                    shadowElevation = 5.dp
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        for ((index, option) in DummyData.serviceOptions.withIndex()) {
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
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontFamily = Montserrat.SemiBold
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = option.price,
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontFamily = Montserrat.SemiBold
                                    ),
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                        .padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }

                // Confirmation button
                Button(
                    onClick = { navController.navigate("${Screen.Riwayat.route}") },
                    modifier = Modifier
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
}

@Preview(showBackground = true)
@Composable
fun PreviewReservationScreen() {
    ReservationScreen(navController = rememberNavController())
}
