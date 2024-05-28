package com.makaraya.more.ui.screen.peta.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.R
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat


@Composable
fun BottomSheetContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    onCancelClick: () -> Unit,
) {
    Column(
        modifier = modifier.padding(8.dp)
    ){
        Icon(
            painter = painterResource(id = R.drawable.iconoir_cancel),
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .padding(bottom = 8.dp)
                .clickable { onCancelClick() }
        )
        Row {
            Image(
                painter = painterResource(id = R.drawable.rekomenbengkel),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(height = 120.dp, width = 120.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
            Column {
                Text(
                    text = "Bengkel A",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                    modifier = modifier.padding(start = 14.dp)
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = "Jl. Gatot Subroto No. 52, Bantul, Yogyakarta",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Montserrat.Regular
                    ),
                    modifier = modifier.padding(start = 14.dp, end = 10.dp, bottom = 8.dp)
                )
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 14.dp),
                        tint = Color.Yellow
                    )
                    Text(
                        text = "4.8",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.Medium
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row (
            modifier = Modifier.padding(horizontal = 10.dp)
        ){
            Button(
                onClick = {
                    val bengkelId = 1
                    navController.navigate("${Screen.DetailBengkel.route}/$bengkelId")
                },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1D4371),
                    contentColor = Color.White
                ),
                modifier = modifier
                    .width(263.dp)
                    .height(45.dp)
            ) {
                Text(
                    text = "Detail Bengkel",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.Medium
                    )
                )
            }
            Spacer(modifier = Modifier.padding(start = 6.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1D4371),
                    contentColor = Color.White
                ),
                modifier = modifier
                    .width(88.dp)
                    .height(45.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Directions,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomSheetContentPrev() {
    MORETheme {
//        BottomSheetContent()
    }
}