package com.makaraya.more.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.model.OnboardingPage
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun OnboardingScreen(
    page: OnboardingPage,
    onNextClicked: () -> Unit,
    pageCount: Int,
    currentPage: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = page.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .padding(top = 100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = page.description,
            fontSize = 20.sp,
            fontFamily = Montserrat.Medium,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )

        Spacer(modifier = Modifier.height(53.dp))

        OnboardingIndicator(pageCount = pageCount, currentPage = currentPage)

        Spacer(modifier = Modifier.height(53.dp))

        Button(onClick = onNextClicked,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 21.dp),
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#1D4371")))
        ) {
            Text(
                text = "Lanjut",
                fontSize = 20.sp,
                fontFamily = Montserrat.Medium,
                textAlign = TextAlign.Center)
        }
    }
}
