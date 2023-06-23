package com.example.hbjracademy.ui.screens.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.hbjracademy.ui.screens.games_detail.GameDetailsState

@Composable
fun FavoritesScreen(
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "There is no favorites found.",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h1
        )
    }
}
