package com.example.marsphotos.ui.screens.realEstateScreen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.marsphotos.ui.screens.ErrorScreen
import com.example.marsphotos.ui.screens.LoadingScreen
import com.example.marsphotos.ui.screens.realEstateScreen.components.RealEstateColumnScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun RealEstateScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val realEstateViewModel = getViewModel<RealEstateViewModel>()
    val estateUiState by realEstateViewModel.realEstateUiState.collectAsState()

    if (estateUiState.isLoading) {
        LoadingScreen(modifier = modifier.fillMaxSize())
    } else if (estateUiState.isError) {
        ErrorScreen(
            modifier = modifier.fillMaxSize()
        )
    } else {
        RealEstateColumnScreen(
            realEstates = estateUiState.realEstates,
            modifier = modifier,
            navController = navController,
            viewModel = realEstateViewModel,
            selectedPosition =realEstateViewModel.getSavedPosition()
        )
    }
}