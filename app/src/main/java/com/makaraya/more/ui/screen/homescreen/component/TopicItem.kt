package com.makaraya.more.ui.screen.homescreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makaraya.more.R
import com.makaraya.more.data.model.Topic
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun TopicItem(
    topic: Topic,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Box (
        modifier = modifier
            .clickable {
                onItemClicked(topic.id)
            }
    ){
        Card (
            modifier = Modifier
                .width(373.dp)
                .height(115.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            ),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    modifier = Modifier.weight(1f)
                ){
                    Text(
                        text = topic.tanggal,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontFamily = Montserrat.Regular
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 4.dp, top = 3.dp ,bottom = 8.dp)
                    )
                    Text(
                        text = topic.judul,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 4.dp, bottom = 6.dp, end = 4.dp)
                    )
                    Text(
                        text = topic.highlightTopic,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontFamily = Montserrat.Regular
                        ),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(start = 4.dp, bottom = 6.dp, end = 4.dp)
                    )
                }
                Image(
                    painter = painterResource(id = topic.photo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(height = 100.dp, width = 100.dp)
                        .clip(RoundedCornerShape(9.dp))

                )
            }



        }
    }
}

@Preview(showBackground = false)
@Composable
private fun TopicItemPrev() {
    MORETheme {
        TopicItem(
            topic = Topic(
                1,
                R.drawable.topik1,
                "Solusi Mudah untuk Mengatasi Masalah Starter Mobil Anda",
                "Irvansius Risky",
                "August 17, 2020",
                "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida.",
                "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in. Auctor proin pulvinar massa ultricies. Condimentum molestie nec habitasse mi feugiat sed ornare et condimentum. Vitae ac potenti faucibus vulputate aenean in leo cursus. Felis accumsan posuere aliquam enim accumsan. Erat ullamcorper gravida in ac sagittis a amet.\n" +
                        "\n" +
                        "Cum egestas congue laoreet ultricies. Lobortis dictumst augue orci fermentum vestibulum. Parturient blandit id in lectus erat vulputate arcu eu. Volutpat id aliquam interdum at pretium amet ut. Lacus lacus consequat urna faucibus ut eget cras enim. Lobortis ultricies consequat aliquam pellentesque. Scelerisque aliquet lectus facilisis elit diam ac. Iaculis neque netus magna eget sit sociis ac cras suspendisse. Morbi nisl libero massa ornare massa gravida. Nulla condimentum massa netus gravida sit volutpat lectus. Enim purus massa in sed."
            ),
            onItemClicked = { topicId ->
                println("Topic Id : $topicId")
            }
        )
    }
}