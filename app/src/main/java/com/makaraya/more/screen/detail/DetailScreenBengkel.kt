package com.makaraya.more.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.makaraya.more.R
import com.makaraya.more.data.DummyData
import com.makaraya.more.model.Bengkel
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun DetailBengkel(
    modifier: Modifier = Modifier,
    navController: NavController,
    bengkelId: Int?
){
    val newBengkelList = DummyData.bengkelPages.filter { bengkel ->
        bengkel.id == bengkelId
    }
    Column(
        modifier = modifier
    ) {
        DetailBengkelContent(newBengkelList = newBengkelList, navController = navController)
    }

}

@Composable
fun DetailBengkelContent(
    newBengkelList: List<Bengkel>,
    navController: NavController,
    modifier: Modifier = Modifier.background(if (isSystemInDarkTheme())Color.DarkGray else Color.White)
) {
    Column (
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        IconButton(
            onClick = {
                navController.navigate("home")
            },
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.menu_home),
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(30.dp)
            )
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = newBengkelList[0].photo)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .shadow(5.dp)
                .size(height = 244.dp, width = 400.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentDescription = ""
        )
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = newBengkelList[0].namaBengkel,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = Montserrat.Bold
                ),
                modifier = modifier.padding(bottom = 10.dp)
            )
            Text(
                text = newBengkelList[0].deskripsi,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = Montserrat.Regular
                ),
                modifier = modifier.padding(bottom = 10.dp)
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(bottom = 10.dp)
            ){
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = stringResource(id = R.string.menu_home),
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(25.dp)
                )
                Text(
                    text = newBengkelList[0].alamat,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(bottom = 10.dp)
            ){
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = stringResource(id = R.string.menu_home),
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(25.dp)
                )
                Text(
                    text = newBengkelList[0].noTelp,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ){
                Button(
                    modifier = modifier
                        .height(45.dp)
                        .width(290.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1D4371),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { /*TODO*/ },
                )
                {
                    Text(
                        text = "Pesan Sekarang",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                    )
                }
                Spacer(modifier = Modifier.padding(end = 3.dp))
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1D4371),
                        contentColor = Color.White
                    ),
                    modifier = modifier
                        .height(45.dp)
                        .width(70.dp),
                )
                {
                    Icon(
                        imageVector = Icons.Default.Chat,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(
                text = "RATING & ULASAN PELANGGAN",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = Montserrat.Bold
                ),
            )
            Card(

            ){

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailBengkelContentPrev() {
    DetailBengkelContent(newBengkelList = DummyData.bengkelPages, navController = rememberNavController())
}