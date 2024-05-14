package com.makaraya.more.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Peta: Screen("peta")
    data object Riwayat: Screen("riwayat")
    data object Profil: Screen("profil")
    data object DetailBengkel: Screen("detail_bengkel")
    data object DetailTopic: Screen("detail_topik")
}