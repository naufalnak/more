package com.makaraya.more.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.R
import com.makaraya.more.model.Bengkel
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun RekomenBengkelItem(
    bengkel: Bengkel,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .clickable {
                onItemClicked(bengkel.id)
            }
    ) {
        Card(
            modifier = Modifier
                .width(210.dp)
                .height(120.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp,Color(0xFFD9D9D9)),
            colors = CardDefaults.cardColors(containerColor = Color.White)
            // Set background color here
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(id = bengkel.photo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    contentScale = ContentScale.Crop
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = bengkel.namaBengkel,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontFamily = Montserrat.Medium
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(4.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Image(
                        painter = painterResource(id = bengkel.rate),
                        contentDescription = "",
                        Modifier
                            .size(16.dp),
                    )
                    Text(
                        text = bengkel.nilaiRate,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontFamily = Montserrat.Medium
                        ),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun RekomenBengkelItemPrev() {
    MORETheme {
        RekomenBengkelItem(
            bengkel = Bengkel(
                1,
                "BENGKEL ANUGRAH",
                "Apakah kendaraan Anda butuh perawatan atau perbaikan? Kami siap membantu Anda! Dengan pengalaman lebih dari 10 tahun, Bengkel Anugrah telah menjadi pilihan terpercaya untuk para pemilik kendaraan.",
                "Jl. Gatot Subroto No. 52 Bantul, Yogyakarta",
                "081-456-098-321",
                R.drawable.rekomenbengkel,
                R.drawable.starrekomen,
                "4.5"
            ),
            onItemClicked = { bengkelId ->
                println("Trend Id : $bengkelId")
            }
        )
    }
}