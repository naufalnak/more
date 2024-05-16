package com.makaraya.more.screen.profil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.makaraya.more.R
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun ProfilScreen() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme())Color.DarkGray else Color.White)
    ){
        val borderWidth = 5.dp
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            ConstraintLayout(){
                val (topImg, profile) = createRefs()
                Image(
                    painter = painterResource(id = R.drawable.bg_photo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(topImg) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.pictureprofile),
                    contentDescription = "PP",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(height = 150.dp, width = 150.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            BorderStroke(borderWidth, Color.White),
                            CircleShape
                        )
                        .constrainAs(profile) {
                            top.linkTo(topImg.bottom)
                            bottom.linkTo(topImg.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
            Spacer(modifier = Modifier.padding(top = 15.dp))
            Text(
                text = "Makaraya",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = Montserrat.SemiBold
                ),
            )
            Text(
                text = "makaraya@gmail.com",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = Montserrat.SemiBold
                ),
            )
            Spacer(modifier = Modifier.padding(top = 60.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        bottom = 10.dp
                    )
                    .height(55.dp)
                    .shadow(5.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(15.dp),
                )
            {
               Column (
                   modifier = Modifier.fillMaxHeight(),
                   verticalArrangement = Arrangement.Center
               ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_edit),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable {},
                    )
               }
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(
                        text = "Edit Profile",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                        maxLines = 1
                    )
                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = "",
                        modifier = Modifier.clickable{},
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        bottom = 10.dp
                    )
                    .height(55.dp)
                    .shadow(5.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(15.dp),
            )
            {
                Column (
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_support),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 5.dp)
                    )
                }
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(
                        text = "Support",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                    )
                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = "",
                        modifier = Modifier.clickable{},
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        bottom = 10.dp
                    )
                    .height(55.dp)
                    .shadow(5.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(15.dp),
            )
            {
                Column (
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_logout),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable {},
                    )
                }
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(
                        text = "Logout",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = Montserrat.SemiBold
                        ),
                    )
                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = "",
                        modifier = Modifier.clickable{},
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfilScreenPrev() {
    MORETheme {
        ProfilScreen()
    }
}