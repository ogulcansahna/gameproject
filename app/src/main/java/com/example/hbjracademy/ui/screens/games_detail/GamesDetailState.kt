package com.example.hbjracademy.ui.screens.games_detail

import com.example.hbjracademy.domain.models.GameDetailsResponse

data class GameDetailsState(
    val isLoading: Boolean = false,
    val gameDetails: GameDetailsResponse? = null,
    val error: String = "",
    val favList: MutableList<GameDetailsResponse>? = mutableListOf()
)