package com.example.marsphotos.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marsphotos.ui.screens.InfoScreen
import com.example.marsphotos.ui.screens.marsPhotosScreen.MarsPhotosScreen
import com.example.marsphotos.ui.screens.marsPhotosScreen.MarsViewModel
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateScreen
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateVIewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationMars(navController: NavHostController, paddingValues: PaddingValues) {
    // val marsViewModel = MarsViewModel(GetMarsPhotosUseCase(GetMarsPhotosRepository(retrofitPhotosService)))
    val marsViewModel: MarsViewModel = koinViewModel()
    val realEstateViewModel: RealEstateVIewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.REALESTATE.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Routes.MARS.route) { MarsPhotosScreen(marsUiState = marsViewModel.marsUiState) }
        composable(Routes.REALESTATE.route) { RealEstateScreen(realEstateUiState = realEstateViewModel.realEstateUiState, navController = navController) }




        composable(Routes.INFOSCREEN.route){ InfoScreen()}
    }
}