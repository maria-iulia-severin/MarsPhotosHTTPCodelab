package com.example.marsphotos.ui.screens.realEstateScreen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.marsphotos.ui.screens.ErrorScreen
import com.example.marsphotos.ui.screens.LoadingScreen
import com.example.marsphotos.ui.screens.realEstateScreen.components.RealEstateColumnScreen

@Composable
fun RealEstateScreen(
    realEstateUiState: RealEstateUiState,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: RealEstateViewModel,
    selectedPosition: Int
) {
    when (realEstateUiState) {
        is RealEstateUiState.Loading -> LoadingScreen(
            modifier = modifier.fillMaxSize()
        )

        is RealEstateUiState.Success -> RealEstateColumnScreen(
            realEstates = realEstateUiState.realEstates,
            modifier = modifier,
            navController = navController,
            viewModel = viewModel,
            selectedPosition = selectedPosition
        )

        is RealEstateUiState.Error -> ErrorScreen(
            modifier = modifier.fillMaxSize()
        )
    }
}