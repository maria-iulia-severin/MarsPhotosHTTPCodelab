package com.example.marsphotos.ui.screens.marsPhotosScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.di.marsPhotos.GetMarsPhotosUseCase
import com.example.marsphotos.network.MarsPhoto
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

class MarsViewModel(
    private val getPhotosUseCase: GetMarsPhotosUseCase
) : ViewModel() {
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                val photos = getPhotosUseCase.getPhotos()
                MarsUiState.Success(photos)
            } catch (e: IOException) {
                MarsUiState.Error
            }
        }
    }
}
