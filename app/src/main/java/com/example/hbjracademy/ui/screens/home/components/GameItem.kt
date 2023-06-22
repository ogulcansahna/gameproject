package com.example.hbjracademy.ui.screens.home.components

import android.graphics.Color.rgb
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.hbjracademy.domain.models.Game
import com.example.hbjracademy.domain.models.Genre
import com.example.hbjracademy.ui.screens.home.HomeViewModel
import com.example.hbjracademy.ui.theme.TextSecondary
import com.google.android.libraries.navigation.internal.abd.it
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import timber.log.Timber


@ExperimentalMaterialApi
@Composable
fun GameItem(
    game: Game,
    viewModel: HomeViewModel = getViewModel(),
    onItemClick: (Game) -> Unit
) {
    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }
    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = { onItemClick(game) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val painter = rememberImagePainter(
                data = game.background_image,
                builder = { crossfade(true) }
            )
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .padding(8.dp, 16.dp)
                    .height(104.dp),
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            if (painter.state is ImagePainter.State.Success) {
                LaunchedEffect(key1 = painter) {
                    launch {
                        val imageDrawable = painter.imageLoader.execute(painter.request).drawable
                        viewModel.getImageDominantSwatch(imageDrawable!!) {
                            dominantColor.value = Color(it.rgb)
                            dominantTextColor.value = Color(it.titleTextColor)
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        text = game.name.toString(),
                        maxLines = 2,
                        style = MaterialTheme.typography.h1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        color = Color.Black
                    )
                    if (game.metacritic!=null){
                        Row() {
                            Text(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                                text = "Metacritic: ",
                                style = MaterialTheme.typography.h2,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                color = Color.Black
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                                text = game.metacritic.toString(),
                                style = MaterialTheme.typography.h3,
                                maxLines = 1,
                                textAlign = TextAlign.End,
                                color = Color(0xFFD80000)
                            )
                        }
                    }else{
                        Spacer(modifier = Modifier.padding(3.dp))
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                        text = game.genres?.let { getGenres(it) }.toString(),
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.h4,
                        maxLines = 2,
                        textAlign = TextAlign.Start,
                        color = Color(0xFF8A8A8F)
                    )
                }
            }

        }
    }
}

    private fun getGenres(genres:List<Genre>):String {
        var allGenres : String = ""
        for (i in 0..genres.size-1) {
            if (i==genres.size-1){
                allGenres+=genres.get(i).name.toString()
            }else{
                allGenres+=genres.get(i).name.toString()+", "
            }
        }
        return allGenres
    }