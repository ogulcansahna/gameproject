package com.example.hbjracademy.ui.screens.games_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.hbjracademy.R
import com.example.hbjracademy.domain.models.Game
import com.example.hbjracademy.domain.models.GameDetailsResponse
import com.example.hbjracademy.ui.screens.home.GamesGrid
import com.example.hbjracademy.ui.screens.home.components.GameItem
import com.example.hbjracademy.ui.screens.home.components.HomeToolbar
import com.example.hbjracademy.ui.theme.TextSecondary
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@Composable
fun GameDetailsScreen(
    gameIdArg: Int,
    viewModel: GameDetailsViewModel = getViewModel(),
    upPressed: () -> Unit
) {


    LaunchedEffect(key1 = gameIdArg) {
        viewModel.getGameDetails(gameId = gameIdArg)
    }

    val gameDetailsState = viewModel.state.value
    val gameDetails = gameDetailsState.gameDetails

    Scaffold(topBar = { GamesToolbar(gameDetails?.name.toString()) }) {
    }
    if (gameDetails != null) {
        BackgroundImage(viewModel = viewModel, gameDetails = gameDetails)
        GameDetail(gameDetails = gameDetails)
        BackButton {
            upPressed()
        }
    } else {
        Timber.e("Game Details is null")
    }
}

@Composable
fun BackgroundImage(viewModel: GameDetailsViewModel, gameDetails: GameDetailsResponse) {
    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }

    val painter = rememberImagePainter(
        data = gameDetails.backgroundImage,
        builder = { crossfade(false) }
    )
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 74.dp)
            .height(275.dp),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        painter = painter,
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
}

@Composable
fun GameDetail(gameDetails: GameDetailsResponse) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(state = scrollState)
    ) {
        Spacer(modifier = Modifier.height(360.dp))

        DetailsText(text = "Game Description")
        DetailsText(text = gameDetails.descriptionRaw.toString())
        goReddit(text = "Visit Reddit",gameDetails.name.toString())
        goWeb(text = "Visit Website",gameDetails.name.toString())
    }
}

@Composable
fun BackButton(modifier: Modifier = Modifier, upPressed: () -> Unit) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .padding(6.dp)
            .alpha(0.6f)
    ) {
        IconButton(onClick = upPressed) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
        }
    }
}
@Composable
fun DetailsText(text: String) {
    Text(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
        text = text,
        style = MaterialTheme.typography.h4,
        fontSize = 10.sp,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Start,
        color = Color(0xFF313131)
    )
}

@Composable
fun goReddit(text: String, name: String) {
    val uriHandler = LocalUriHandler.current
    val uri = "https://www.reddit.com/search/?q=" + name
    Text(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp).clickable {
            uriHandler.openUri(uri)
        },
        text = text,
        style = MaterialTheme.typography.h1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Start,
        color = Color(0xFF313131)
    )
}

@Composable
fun goWeb(text: String, name: String) {
    val uriHandler = LocalUriHandler.current
    val uri = "https://www.google.com/search?q=" + name
    Text(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp).clickable {
            uriHandler.openUri(uri)
        },
        text = text,
        style = MaterialTheme.typography.h1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Start,
        color = Color(0xFF313131)
    )
}