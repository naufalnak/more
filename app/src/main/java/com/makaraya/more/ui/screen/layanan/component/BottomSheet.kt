package com.makaraya.more.ui.screen.layanan.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetCompose(
    showBottomSheet: MutableState<Boolean>,
    onDetailsSaved: (String, String) -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    var detailLokasi by remember { mutableStateOf("") }
    var patokan by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = {
            showBottomSheet.value = false
        },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                TextField(
                    value = detailLokasi,
                    onValueChange = { detailLokasi = it },
                    label = { Text("Detail Lokasi (optional) ") },
                    placeholder = { Text("Contoh: No. rumah/unit/lantai") },
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black
                    )
                )

                TextField(
                    value = patokan,
                    onValueChange = { patokan = it },
                    label = { Text("Patokan (optional) ") },
                    placeholder = { Text("Contoh: Posisi sebelah toko roti") },
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black
                    )
                )

                Button(
                    onClick = {
                        coroutineScope.launch {
                            modalBottomSheetState.hide()
                            showBottomSheet.value = false
                            onDetailsSaved(detailLokasi, patokan)
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D4371))
                ) {
                    Text(
                        text = "Simpan",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }
    )
}
