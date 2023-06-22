package com.example.hbjracademy.presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.hbjracademy.domain.model.Games

@Composable
fun GamesListItem(
    games: Games,
    onItemClick: (Games) -> Unit
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(games) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${games.id}. ${games.ratings_count}. ${games.rating}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis

        )
    }

}