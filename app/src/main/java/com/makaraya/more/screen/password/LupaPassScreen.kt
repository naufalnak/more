package com.makaraya.more.screen.password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.makaraya.more.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LupaPassScreen() {

    var email by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
    ) {
        Text(
            text = "Lupa Kata Sandi?",
            style = TextStyle(
                color = Color.Black,
                fontSize = 28.sp,
                fontFamily = Montserrat.Bold
            )
        )

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Jangan khawatir itu terjadi. " +
                "Silakan masukkan email yang akan kami kirimkan OTP di email ini.",
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
            value = email ,
            onValueChange = {email = it},
            placeholder = { Text(text = "Email")},
            label = { Text(
                text = "Email",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = Montserrat.SemiBold
                )
            )},
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(android.graphics.Color.parseColor("#8AB7E1")),
                unfocusedBorderColor = Color(android.graphics.Color.parseColor("#8AB7E1"))
            ),
            modifier = Modifier
                .width(316.dp)
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
                text = "Kirim",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = Montserrat.Medium
                )
            )
        }
    }
}