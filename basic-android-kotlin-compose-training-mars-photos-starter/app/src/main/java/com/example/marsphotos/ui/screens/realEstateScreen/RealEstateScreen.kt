package com.example.marsphotos.ui.screens.realEstateScreen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.marsphotos.ui.screens.ErrorScreen
import com.example.marsphotos.ui.screens.LoadingScreen
import com.example.marsphotos.ui.screens.realEstateScreen.components.RealEstateColumnScreen

@Composable
fun RealEstateScreen(
    realEstateUiState: RealEstateUiState,
    modifier: Modifier = Modifier
) {
    when (realEstateUiState) {
        is RealEstateUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is RealEstateUiState.Success -> RealEstateColumnScreen(
            realEstateUiState.realEstates,
            modifier
        )
        is RealEstateUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

