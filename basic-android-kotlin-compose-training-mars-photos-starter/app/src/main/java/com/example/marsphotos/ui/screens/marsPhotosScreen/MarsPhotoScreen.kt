package com.example.marsphotos.ui.screens.marsPhotosScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.marsphotos.ui.screens.ErrorScreen
import com.example.marsphotos.ui.screens.LoadingScreen
import com.example.marsphotos.ui.screens.marsPhotosScreen.components.PhotosGridScreen

@Composable
fun MarsPhotosScreen(
    marsUiState: MarsUiState,
    modifier: Modifier = Modifier
) {
    when (marsUiState) {
        is MarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is MarsUiState.Success -> PhotosGridScreen(marsUiState.photos, modifier)
        is MarsUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}