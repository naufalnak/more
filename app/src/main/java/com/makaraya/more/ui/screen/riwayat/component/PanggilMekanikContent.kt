package com.makaraya.more.ui.screen.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.makaraya.more.data.model.Riwayat

@Composable
fun PanggilMekanikContent() {
    val riwayat = Riwayat(
        1,
        "Bengkel Anugrah",
        "Sepeda Motor",
        "04 Mei 2024",
        "Mobil mengeluarkan asap putih dari kap mesin",
        "Rp 58.300"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            Modifier.padding(8.dp)
        ){
            PanggilMekanikItem(riwayat = riwayat)
        }
    }
}