package com.example.hbjracademy.presentation.list

import com.example.hbjracademy.common.Resource
import com.example.hbjracademy.domain.model.Games

data class GamesListState(
    val isLoading: Boolean = false,
    val games: List<Games> = emptyList(),
    val error: String = ""


)
