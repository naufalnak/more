package com.makaraya.more.ui.screen.pendaftaran

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.makaraya.more.R
import com.makaraya.more.data.model.User
import com.makaraya.more.data.response.Status
import com.makaraya.more.ui.theme.Montserrat
import com.makaraya.more.utils.SweetAlerts
import com.makaraya.more.utils.SweetAlerts.success

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nomortelepon by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(true) }
    var confirmPasswordVisibility by remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Buat Akun", style = TextStyle(
                fontSize = 30.sp, fontFamily = Montserrat.Bold
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Buatlah akun agar Anda dapat menjelajahi  \n  semua toko yang ada",
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
                text = "Nama", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Montserrat.SemiBold,
                )
            )
            OutlinedTextField(value = nama,
                onValueChange = { nama = it },
                label = { Text(text = "") },
                shape = RoundedCornerShape(16.dp),
                isError = isError.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1), // Warna biru dengan nilai hex
                    unfocusedBorderColor = Color(0xFF8AB7E1), // Warna abu-abu dengan nilai hex
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
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
                isError = isError.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1), // Warna biru dengan nilai hex
                    unfocusedBorderColor = Color(0xFF8AB7E1), // Warna abu-abu dengan nilai hex
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Nomor Telepon", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Montserrat.SemiBold,
                )
            )
            OutlinedTextField(value = nomortelepon,
                onValueChange = { nomortelepon = it },
                label = { Text(text = "") },
                shape = RoundedCornerShape(16.dp),
                isError = isError.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1), // Warna biru dengan nilai hex
                    unfocusedBorderColor = Color(0xFF8AB7E1), // Warna abu-abu dengan nilai hex
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
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
                isError = isError.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1), // Warna biru dengan nilai hex
                    unfocusedBorderColor = Color(0xFF8AB7E1), // Warna abu-abu dengan nilai hex
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

            Text(
                text = "Konfirmasi Kata Sandi", style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Montserrat.SemiBold,
                )
            )

            OutlinedTextField(value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text(text = "") },
                shape = RoundedCornerShape(16.dp),
                isError = isError.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8AB7E1), // Warna biru dengan nilai hex
                    unfocusedBorderColor = Color(0xFF8AB7E1), // Warna abu-abu dengan nilai hex
                    cursorColor = Color.Black
                ),
                visualTransformation = if (confirmPasswordVisibility) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                trailingIcon = {
                    IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                        Icon(
                            imageVector = if (confirmPasswordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                val user = User(
                    email = email,
                    password = password,
                    nama_user = nama,
                    no_tlp = nomortelepon,
                    confPassword = confirmPassword)
                registerViewModel.saveUserData(user)
                registerViewModel.savedUserStatus.observeForever { result ->
                    when (result.status) {
                        Status.SUCCESS -> {
                            success(context, "Success", "Registrasi Berhasil") {
                                navController.navigate("home")
                            }
                        }
                        Status.LOADING -> {
                            loading(context, "Loading")
                        }
                        Status.ERROR -> {
                            error(context, "Oops", result.message ?: "Error occurred")
                        }
                        else -> {}
                    }
                }

            },
            modifier = Modifier
                .width(316.dp)
                .height(45.dp)
            ,
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#1D4371")))
        ) {
            Text(
                text = "Register", style = TextStyle(
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
                text = "atau Daftar dengan", style = TextStyle(
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
                    .clickable { /* Facebook clicked */ })
            Spacer(modifier = Modifier.width(24.dp))
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(60.dp)
                    .clickable { /* Google clicked */ })
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sudah punya akun? ",
                style = TextStyle(
                    fontFamily = Montserrat.Regular,
                    fontSize = 14.sp,
                    color = Color.Gray,
                ),
            )
            Text(text = "Masuk", style = TextStyle(
                fontFamily = Montserrat.SemiBold,
                fontSize = 14.sp,
                color = Color(0xFF1D4371),
            ), modifier = Modifier.clickable { navController.navigate("signin") })
        }
    }
}


private fun inputValidation(email: String, password: String, navController: NavController, registerViewModel: RegisterViewModel, context: Context) {
    val user = User(email, password)
    registerViewModel.saveUserData(user)
    registerViewModel.savedUserStatus.observeForever { result ->
        when (result.status) {
            Status.SUCCESS -> {
                com.makaraya.more.ui.screen.pendaftaran.success(context, "Success", "Member ${result.data} Saved Successfully") {
                    navController.navigate("login_page")
                }
            }
            Status.LOADING -> {
                loading(context, "Loading")
            }
            Status.ERROR -> {
                error(context, "Oops", result.message ?: "Error occurred")
            }
            else -> {}
        }
    }
}

private fun success(context: Context, title: String, msg: String, dismiss: () -> Unit = {}) {
    SweetAlerts.success(context = context, title = title, msg = msg, dismiss = dismiss)
}

private fun error(context: Context, title: String, msg: String, dismiss: () -> Unit = {}) {
    SweetAlerts.error(context = context, title = title, msg = msg, dismiss = dismiss)
}

private fun loading(context: Context, msg: String) {
    SweetAlerts.loading(context = context, msg = msg)
}

@Preview
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(navController = rememberNavController())
}

