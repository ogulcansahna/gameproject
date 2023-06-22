package com.example.hbjracademy.ui.navigation

import com.example.hbjracademy.R

sealed class NavigationItem(var route: String, var title: String, var icon: Int?) {

    object Home : NavigationItem("home", "Games", R.drawable.ic_home)
    object Favorite : NavigationItem("favorites", "Favorites", R.drawable.ic_favorite)
    object GameDetails : NavigationItem("details/{gameId}", "Game Details", null)

}