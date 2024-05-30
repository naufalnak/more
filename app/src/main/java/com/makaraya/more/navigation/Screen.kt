package com.makaraya.more.navigation

sealed class Screen (val route: String){

    data object Onboarding : Screen("onboarding")
    data object SignIn : Screen("signin")
    data object SignUp : Screen("signup")
    data object LupaPass: Screen("lupa_pass")
    data object NewPass: Screen("new_pass")
    data object Verif: Screen("verif")
    data object Home : Screen("home")
    data object Peta: Screen("peta")
    data object Riwayat: Screen("riwayat")
    data object Profil: Screen("profil")
    data object DetailBengkel: Screen("detail_bengkel")
    data object DetailTopic: Screen("detail_topik")
    data object PanggilMekanik: Screen("panggil_mekanik")
    data object Reservation: Screen("reservation")
    data object Pembayaran: Screen("pembayaran")
}