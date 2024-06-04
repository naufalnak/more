package com.makaraya.more.screen.succes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.theme.Montserrat
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.makaraya.more.R
import com.airbnb.lottie.compose.LottieConstants


@Composable
fun SuccesScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
    ){
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(resId = R.raw.animasi_succes)
        )
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )


        Text(
            text = "Pembayaran",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontFamily = Montserrat.Bold
            )
        )
        Text(
            text = "Berhasil",
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontFamily = Montserrat.Bold
            )
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { navController.navigate(Screen.Riwayat.route) },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(android.graphics.Color.parseColor("#1D4371"))
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                brush = SolidColor(Color(android.graphics.Color.parseColor("#1D4371")))
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 25.dp, top = 2.dp, end = 25.dp),
        ) {
            Text(text = "Lihat Riwayat", fontFamily = Montserrat.SemiBold)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 25.dp, top = 2.dp, end = 25.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1D4371)
            )
        ) {
            Text(text = "Beranda", fontFamily = Montserrat.SemiBold)
        }
    }
}

@Preview
@Composable
fun PreviewSuccesScreen() {
    SuccesScreen(navController = rememberNavController())
}
