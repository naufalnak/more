package com.makaraya.more.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.R
import com.makaraya.more.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Masuk", style = TextStyle(
                fontSize = 30.sp, fontFamily = Montserrat.Bold
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Masukkan akun agar Anda dapat menjelajahi \n  semua toko yang ada",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = Montserrat.Medium,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier.fillMaxWidth(0.8f), horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Email", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Montserrat.SemiBold,
                )
            )
            OutlinedTextField(value = email,
                onValueChange = { email = it },
                label = { Text(text = "") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1),
                    unfocusedBorderColor = Color(0xFF8AB7E1),
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Kata Sandi", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Montserrat.SemiBold,
                )
            )

            OutlinedTextField(value = password,
                onValueChange = { password = it },
                label = { Text(text = "") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1),
                    unfocusedBorderColor = Color(0xFF8AB7E1),
                    cursorColor = Color.Black
                ),
                visualTransformation = if (passwordVisibility) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Forgot Password?", style = TextStyle(
                    fontFamily = Montserrat.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFF3366CC),
                ), modifier = Modifier.clickable {  })
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#1D4371")))
        ) {
            Text(
                text = "Login", style = TextStyle(
                    fontFamily = Montserrat.Medium, fontSize = 16.sp, color = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Color.Gray, modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            Text(
                text = "atau Masuk dengan", style = TextStyle(
                    fontFamily = Montserrat.Light, fontSize = 14.sp
                )
            )

            Divider(
                color = Color.Gray, modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(60.dp)
                    .clickable { })
            Spacer(modifier = Modifier.width(24.dp))
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(60.dp)
                    .clickable { })
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum punya akun? ",
                style = TextStyle(
                    fontFamily = Montserrat.Regular,
                    fontSize = 14.sp,
                    color = Color.Gray,
                ),
            )
            Text(text = "Daftar", style = TextStyle(
                fontFamily = Montserrat.SemiBold,
                fontSize = 14.sp,
                color = Color(0xFF1D4371),
            ), modifier = Modifier.clickable { navController.navigate("register") })
        }

    }
}

