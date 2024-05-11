package com.makaraya.more

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.makaraya.more.data.DummyData
import com.makaraya.more.presentation.component.OnboardingView
import com.makaraya.more.presentation.component.SplashScreen
import com.makaraya.more.ui.theme.MORETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MORETheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash_screen") {
                    composable("splash_screen") {
                        SplashScreen(navController = navController)
                    }
                    composable("onboarding_screen") {
                        OnboardingView(
                            pages = DummyData.onboardingPages,
                            onComplete = {
                            }
                        )
                    }
                }
            }
        }
    }
}