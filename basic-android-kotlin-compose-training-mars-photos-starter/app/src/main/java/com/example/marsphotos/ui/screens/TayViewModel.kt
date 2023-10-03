package com.example.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.network.TayAlbum
import com.example.marsphotos.network.TayApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface TayUiState {
    data class Success(val albums: TayAlbum) : TayUiState
    object Error : TayUiState
    object Loading : TayUiState
}

class TayViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var tayUiState: TayUiState by mutableStateOf(TayUiState.Loading)
        private set

    init {
        getTayAlbum()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     *
     */
    private fun getTayAlbum() {
        viewModelScope.launch {
            tayUiState = try {
                TayUiState.Success(TayApi.retrofitServiceTay.getAlbums()[0])
            } catch (e: IOException) {
                TayUiState.Error
            }
        }
    }
}
