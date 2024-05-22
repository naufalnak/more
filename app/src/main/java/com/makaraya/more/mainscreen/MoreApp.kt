package com.makaraya.more.mainscreen

import PanggilMekanikScreen
import ReservationScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.makaraya.more.screen.detail.DetailBengkel
import com.makaraya.more.screen.detail.DetailTopic
import com.makaraya.more.screen.homescreen.HomeScreen
import com.makaraya.more.screen.peta.PetaScreen
import com.makaraya.more.screen.profil.ProfilScreen
import com.makaraya.more.screen.riwayat.RiwayatScreen
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat

@Composable
fun MoreApp(
    modifier: Modifier = Modifier,
) {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold (
        bottomBar = {
            BottomAppBar (
                containerColor = Color.White,
                modifier = Modifier
                    .shadow(8.dp)
            ){
                // Home
                IconButton(
                    onClick = {
                            selected.value = Icons.Default.Home
                        navigationController.navigate(Screen.Home.route){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Home) Color(0xFF1D4371) else Color.Gray
                        )
                        Text(
                            text = "Home",
                            style = TextStyle(
                                color = if (selected.value == Icons.Default.Home) Color(0xFF1D4371) else Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.Medium
                            ),
                        )
                    }
                }

                // Map
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.LocationOn
                        navigationController.navigate(Screen.Peta.route){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.LocationOn) Color(0xFF1D4371) else Color.Gray
                        )
                        Text(
                            text = "Peta",
                            style = TextStyle(
                                color = if (selected.value == Icons.Default.LocationOn) Color(0xFF1D4371) else Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.Medium
                            ),
                        )
                    }
                }

                // History
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.ListAlt
                        navigationController.navigate(Screen.Riwayat.route){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = Icons.Default.ListAlt,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.ListAlt) Color(0xFF1D4371) else Color.Gray
                        )
                        Text(
                            text = "Riwayat",
                            style = TextStyle(
                                color = if (selected.value == Icons.Default.ListAlt) Color(0xFF1D4371) else Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.Medium
                            ),
                        )
                    }
                }

                // Profil
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screen.Profil.route){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Person) Color(0xFF1D4371) else Color.Gray
                        )
                        Text(
                            text = "Profil",
                            style = TextStyle(
                                color = if (selected.value == Icons.Default.Person) Color(0xFF1D4371) else Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = Montserrat.Medium
                            ),
                        )
                    }
                }
            }
        }
    ){contentPadding ->
        NavHost(
            navController = navigationController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(contentPadding)
        ){
            composable(Screen.Home.route){
                HomeScreen(navigationController)
            }

            composable(Screen.Peta.route){
                PetaScreen(navigationController)
            }

            composable(Screen.Riwayat.route){
                RiwayatScreen()
            }

            composable(Screen.Profil.route){
                ProfilScreen()
            }

            composable(
                Screen.DetailBengkel.route + "/{bengkelId}",
                arguments = listOf(navArgument("bengkelId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailBengkel(
                    navController = navigationController,
                    bengkelId = navBackStackEntry.arguments?.getInt("bengkelId")
                )
            }

            composable(
                Screen.PanggilMekanik.route
            ){
                PanggilMekanikScreen(navigationController)
            }

            composable(
                Screen.Reservation.route
            ){
                ReservationScreen(navigationController)
            }

            composable(
                Screen.DetailTopic.route + "/{topicId}",
                arguments = listOf(navArgument("topicId"){
                    type = NavType.IntType
                })
            ){navBackStackEntry->
                DetailTopic(
                    navController = navigationController,
                    topicId = navBackStackEntry.arguments?.getInt("topicId")
                )
            }
        }
    }
}

@Preview
@Composable
private fun MoreAppPrev() {
    MORETheme{
        MoreApp()
    }
}