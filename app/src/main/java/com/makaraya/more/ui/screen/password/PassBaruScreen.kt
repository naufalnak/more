package com.makaraya.more.ui.screen.password

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassBaruScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    var newpassword by remember {
        mutableStateOf("")
    }
    var confirmpass by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(top = 95.dp)
        ){
            Text(
                text = "Buat Kata Sandi Baru",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontFamily = Montserrat.Bold
                )
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Masukkan akun agar Anda dapat menjelajahi semua toko yang ada",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = Montserrat.Medium
                ),
                modifier = Modifier.widthIn(max = 300.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = newpassword ,
                onValueChange = {newpassword = it},
                placeholder = { Text(text = "Kata Sandi Baru") },
                label = { Text(
                    text = "Kata Sandi Baru",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.SemiBold
                    )
                )
                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#8AB7E1")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#8AB7E1"))
                ),
                modifier = Modifier
                    .width(316.dp),
                trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.VisibilityOff,
                        contentDescription = "VisibilityOff Icon",
                        tint = Color.Black
                    )
                }}
            )

            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = confirmpass ,
                onValueChange = {confirmpass = it},
                placeholder = { Text(text = "Konfirmasi Kata Sandi Baru") },
                label = { Text(
                    text = "Konfirmasi Kata Sandi Baru",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.SemiBold
                    )
                )
                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#8AB7E1")),
                    unfocusedBorderColor = Color(android.graphics.Color.parseColor("#8AB7E1"))
                ),
                modifier = Modifier
                    .width(316.dp),
                trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.VisibilityOff,
                        contentDescription = "VisibilityOff Icon",
                        tint = Color(android.graphics.Color.parseColor("#8AB7E1"))
                    )
                }}
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#1D4371"))),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .width(318.dp)
                    .height(49.dp)
            ) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = Montserrat.Medium
                    )
                )
            }
        }
    }
}