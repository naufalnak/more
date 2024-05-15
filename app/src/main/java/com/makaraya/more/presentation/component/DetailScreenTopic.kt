package com.makaraya.more.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.makaraya.more.R
import com.makaraya.more.data.DummyData
import com.makaraya.more.model.Topic
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun DetailTopic(
    modifier: Modifier = Modifier,
    navController: NavController,
    topicId: Int?
) {
    val newTopicList = DummyData.topicPages.filter { topic ->
        topic.id == topicId
    }
    Column(
        modifier = modifier
    ) {
        DetailTopicContent(newTopicList = newTopicList, navController = navController)
    }
}

@Composable
fun DetailTopicContent(
    newTopicList: List<Topic>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
                .data(data = newTopicList[0].photo)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(height = 244.dp, width = 400.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentDescription = ""
        )
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ){
            Text(
                text = newTopicList[0].judul,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = Montserrat.SemiBold
                ),
            )
            Row (
                modifier = Modifier.padding(top = 16.dp)
            ){
                Text(
                    text = "Penulis : ",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.Regular
                    ),
                )
                Text(
                    text = newTopicList[0].penulis,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                    modifier = modifier.padding(end = 140.dp)
                )
                Text(
                    text = newTopicList[0].tanggal,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.Regular
                    ),
                    maxLines = 1
                )
            }
            Divider(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            Column (
                modifier = Modifier.padding(top = 15.dp)
            ){
                Text(
                    text = newTopicList[0].isiTopic,
                )

            }
            Column (
                modifier = Modifier.padding(top = 16.dp)
            ){
                Text(
                    text = "Tags : ",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = Montserrat.SemiBold
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailTopicContentPrev() {
    DetailTopicContent(newTopicList = DummyData.topicPages,navController = rememberNavController())
}