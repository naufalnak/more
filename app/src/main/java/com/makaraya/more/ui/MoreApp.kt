package com.makaraya.more.ui

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.android.gms.auth.api.identity.Identity
import com.makaraya.more.data.DummyData
import com.makaraya.more.ui.screen.detail.DetailBengkel
import com.makaraya.more.ui.screen.detail.DetailTopic
import com.makaraya.more.navigation.Screen
import com.makaraya.more.ui.screen.homescreen.HomeScreen
import com.makaraya.more.ui.screen.layanan.PanggilMekanikScreen
import com.makaraya.more.ui.screen.layanan.ReservationScreen
import com.makaraya.more.ui.screen.onboarding.OnboardingView
import com.makaraya.more.ui.screen.password.LupaPassScreen
import com.makaraya.more.ui.screen.password.PassBaruScreen
import com.makaraya.more.ui.screen.pembayaran.PembayaranScreen
import com.makaraya.more.ui.screen.pendaftaran.RegisterScreen
import com.makaraya.more.ui.screen.peta.PetaScreen
import com.makaraya.more.ui.screen.profil.ProfilScreen
import com.makaraya.more.ui.screen.riwayat.RiwayatScreen
import com.makaraya.more.ui.screen.signin.GoogleAuthUiClient
import com.makaraya.more.ui.screen.signin.SignInScreen
import com.makaraya.more.ui.screen.signin.SignInViewModel
import com.makaraya.more.ui.screen.splash.SplashScreen
import com.makaraya.more.ui.screen.verifikasi.VerifikasiScreen
import com.makaraya.more.ui.theme.MORETheme
import com.makaraya.more.ui.theme.Montserrat
import com.makaraya.more.utils.PreferenceHelper
import com.makaraya.more.utils.shouldShowBottomBar
import kotlinx.coroutines.launch


@Composable
fun MoreApp() {
    val navController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val isOnboardingComplete = PreferenceHelper.isOnboardingComplete(context)

    val googleAuthUiClient by remember {
        mutableStateOf(
            GoogleAuthUiClient(
                context = context,
                oneTapClient = Identity.getSignInClient(context)
            )
        )
    }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar(),
            ) {
                BottomAppBar (
                    containerColor = Color.White,
                    modifier = Modifier
                        .shadow(8.dp)
                ){
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navController.navigate(Screen.Home.route){
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

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.LocationOn
                            navController.navigate(Screen.Peta.route){
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

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.ListAlt
                            navController.navigate(Screen.Riwayat.route){
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

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navController.navigate(Screen.Profil.route){
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
        },
    ){contentPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(contentPadding)
        ){
            composable("home") {
                SplashScreen(navController = navController)
            }
            composable("onboarding_screen") {
                if (isOnboardingComplete) {
                    navController.navigate(Screen.SignIn.route)
                } else {
                    OnboardingView(
                        pages = DummyData.onboardingPages,
                        onComplete = {
                            PreferenceHelper.setOnboardingComplete(context, true)
                            navController.navigate(Screen.SignIn.route)
                        }
                    )
                }
            }
            composable(Screen.SignIn.route) {
                val viewModel = viewModel<SignInViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit) {
                    if(googleAuthUiClient.getSignedInUser() != null) {
                        navController.navigate(Screen.Home.route)
                    }
                }

                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartIntentSenderForResult(),
                    onResult = { result ->
                        if(result.resultCode == Activity.RESULT_OK) {
                            coroutineScope.launch {
                                val signInResult = googleAuthUiClient.signInWithIntent(
                                    intent = result.data ?: return@launch
                                )
                                viewModel.onSignInResult(signInResult)
                            }
                        }
                    }
                )

                LaunchedEffect(key1 = state.isSignInSuccessful) {
                    if(state.isSignInSuccessful) {
                        Toast.makeText(
                            context,
                            "Sign in successful",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate(Screen.Home.route)
                        viewModel.resetState()
                    }
                }

                SignInScreen(
                    state = state,
                    onSignInClick = {
                        coroutineScope.launch {
                            val signInIntentSender = googleAuthUiClient.signIn()
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    signInIntentSender ?: return@launch
                                ).build()
                            )
                        }
                    },
                    navController = navController,
                )
            }
            composable(Screen.SignUp.route) {
                RegisterScreen(navController)
            }

            composable(Screen.LupaPass.route) {
                LupaPassScreen(navController)
            }

            composable(Screen.NewPass.route) {
                PassBaruScreen(navController)
            }

            composable(Screen.Verif.route) {
                VerifikasiScreen(navController)
            }

            composable(Screen.Home.route){
                HomeScreen(navController)
            }

            composable(Screen.Peta.route){
                PetaScreen(navController)
            }

            composable(Screen.Riwayat.route){
                RiwayatScreen()
            }

            composable(Screen.Profil.route){
                ProfilScreen(
                    userData = googleAuthUiClient.getSignedInUser(),
                    onSignOut = {
                        coroutineScope.launch {
                            googleAuthUiClient.signOut()
                            Toast.makeText(
                                context,
                                "Signed out",
                                Toast.LENGTH_LONG
                            ).show()

                            navController.navigate(Screen.SignIn.route) {
                                popUpTo(Screen.Profil.route) {
                                    inclusive = true
                                }
                            }
                        }
                    },
                    navController = navController,
                )
            }

            composable(
                Screen.DetailBengkel.route + "/{bengkelId}",
                arguments = listOf(navArgument("bengkelId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailBengkel(
                    navController = navController,
                    bengkelId = navBackStackEntry.arguments?.getInt("bengkelId")
                )
            }

            composable(
                Screen.PanggilMekanik.route
            ){
                PanggilMekanikScreen(navController)
            }

            composable(
                Screen.Reservation.route
            ){
                ReservationScreen(navController)
            }

            composable(
                Screen.Pembayaran.route
            ){
                PembayaranScreen(navController)
            }

            composable(
                Screen.DetailTopic.route + "/{topicId}",
                arguments = listOf(navArgument("topicId"){
                    type = NavType.IntType
                })
            ){navBackStackEntry->
                DetailTopic(
                    navController = navController,
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