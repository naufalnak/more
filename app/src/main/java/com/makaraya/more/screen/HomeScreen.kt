package com.makaraya.more.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.makaraya.more.R
import com.makaraya.more.component.RekomenBengkelItem
import com.makaraya.more.component.TopicItem
import com.makaraya.more.data.DummyData
import com.makaraya.more.model.Bengkel
import com.makaraya.more.model.Topic
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    topic: List<Topic> = DummyData.topicPages,
    bengkel: List<Bengkel> = DummyData.bengkelPages,
) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            Column (
                modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Column (
                        modifier = modifier.padding(top = 16.dp, end = 200.dp)
                    ){
                        Text(
                            text = "Hi, Makaraya",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontFamily = Montserrat.SemiBold
                            ),
                        )
                        Text(
                            text = "Booking & Service",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 10.sp,
                                fontFamily = Montserrat.SemiBold
                            ),
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.pictureprofile),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(height = 30.dp, width = 30.dp)
                            .clip(CircleShape)
                            .clip(RoundedCornerShape(16.dp))
                            .align(Alignment.CenterVertically)
                    )
                }
                Box(
                    modifier = modifier
                        .padding(15.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.carousel),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .shadow(10.dp)
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Bengkel Andalan",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                        modifier = modifier.padding(end = 140.dp)
                    )
                    Text(
                        text = "Lihat Semua",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                    )
                }
                LazyRow (
                    contentPadding = PaddingValues(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(bengkel, key = { it.id }) {
                        RekomenBengkelItem(
                            bengkel = it,
                            modifier = modifier.padding(bottom = 16.dp)
                        ) { bengkelId ->
                            navController.navigate(Screen.DetailBengkel.route + "/$bengkelId")
                        }
                    }
                }
                Text(
                    text = "Topik",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
        items(topic, key = {it.id}){
            TopicItem(
                topic = it,
                modifier = modifier.padding(horizontal = 16.dp)
            ){
                    topicId ->
                navController.navigate(Screen.DetailTopic.route + "/$topicId")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun HomeScreenPrev() {
//    MORETheme{
//        HomeScreen()
//    }
//}