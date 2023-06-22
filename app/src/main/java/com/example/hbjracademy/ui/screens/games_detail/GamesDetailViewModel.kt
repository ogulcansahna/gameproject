package com.example.hbjracademy.ui.screens.games_detail

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.hbjracademy.common.Resource
import com.example.hbjracademy.domain.use_case.GetGameDetailsUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class GameDetailsViewModel constructor(private val getGameDetailsUseCase: GetGameDetailsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(GameDetailsState())
    val state: State<GameDetailsState> = _state

    fun getGameDetails(gameId: Int) {
        viewModelScope.launch {
            val result = getGameDetailsUseCase.invoke(gameId = gameId)

            Timber.e("Getting game details in viewModel")


            when (result) {
                is Resource.Loading -> {
                    _state.value = GameDetailsState(isLoading = true)
                    Timber.e("Loading state")
                }
                is Resource.Success -> {
                    _state.value = GameDetailsState(gameDetails = result.data)
                    Timber.e("Success state")
                }
                is Resource.Error -> {
                    _state.value =
                        GameDetailsState(error = result.message ?: "An unexpected error occurred")
                    Timber.e("Failure state")
                }

            }
        }
    }

    fun getImageDominantSwatch(drawable: Drawable, onGenerated: (Palette.Swatch) -> Unit) {
        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bitmap).generate { palette ->
            palette?.dominantSwatch?.let {
                onGenerated(it)
            }
        }
    }
}