package com.makaraya.more.screen.riwayat


import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.makaraya.more.screen.riwayat.component.PanggilMekanikContent
import com.makaraya.more.screen.riwayat.component.ReservasiContent
import com.makaraya.more.screen.riwayat.component.TabItem
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun RiwayatScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme())Color.DarkGray else Color.White)
    ) {
        Text(
            text = "Riwayat Perbaikan",
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = Montserrat.SemiBold,
            ),
            modifier = Modifier
                .padding(14.dp)
                .align(Alignment.CenterHorizontally)
        )
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.White,
            contentColor = Blue,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(0.dp) // Remove the default indicator
                )
            },
            divider = {} // Remove the default divider
        ) {
            TabItem(
                text = "Reservasi",
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 }
            )
            TabItem(
                text = "Panggil Mekanik",
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 }
            )
        }
        // Content based on the selected tab
        when (selectedTabIndex) {
            0 -> ReservasiContent()
            1 -> PanggilMekanikContent()
        }
    }
}

@Preview
@Composable
private fun RiwayatScreenPrev() {
    MORETheme {
        RiwayatScreen()
    }
}