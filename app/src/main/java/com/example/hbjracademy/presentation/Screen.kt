package com.example.hbjracademy.presentation

sealed class Screen(val route:String){
    object GamesListScreen: Screen("games_list_screen")
    object GamesDetailScreen: Screen("games_detail_screen")

}
