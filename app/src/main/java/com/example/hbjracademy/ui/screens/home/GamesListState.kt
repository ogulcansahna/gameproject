package com.example.hbjracademy.ui.screens.home

import com.example.hbjracademy.domain.models.GamesResponse

data class GamesListState(
    val isLoading: Boolean=false,
    val games: GamesResponse?=null,
    val error: String = ""
)