package com.example.hbjracademy.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hbjracademy.common.Resource
import com.example.hbjracademy.domain.use_case.get_lists.getListsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GamesListViewModel @Inject constructor(
    private val getListsUseCase: getListsUseCase,
    private val savedStateHandle: SavedStateHandle //ıc menu ıcın
) : ViewModel() {
    private val _state = mutableStateOf(GamesListState())
    val state: State<GamesListState> = _state

    init {
        getGames()
    }

    private fun getGames(){
        getListsUseCase().onEach { result ->
            when (result){
                is Resource.Success -> {
                    _state.value = GamesListState(games = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = GamesListState(error = result.message ?: "Unexpected Error Occured")
                }
                is Resource.Loading -> {
                    _state.value = GamesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}