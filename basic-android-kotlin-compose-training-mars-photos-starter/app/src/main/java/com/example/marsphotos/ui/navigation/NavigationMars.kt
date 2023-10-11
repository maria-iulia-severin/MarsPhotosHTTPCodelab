package com.example.marsphotos.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marsphotos.ui.screens.InfoScreen
import com.example.marsphotos.ui.screens.marsPhotosScreen.MarsPhotosScreen
import com.example.marsphotos.ui.screens.marsPhotosScreen.MarsViewModel
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateScreen
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationMars(navController: NavHostController, paddingValues: PaddingValues) {
    val marsViewModel: MarsViewModel = koinViewModel()
    val realEstateViewModel: RealEstateViewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.REALESTATE.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = Routes.MARS.route) { MarsPhotosScreen(marsUiState = marsViewModel.marsUiState) }
        composable(route = Routes.REALESTATE.route) {
            RealEstateScreen(
                realEstateUiState = realEstateViewModel.realEstateUiState,
                navController = navController
            )
        }
        composable(
            route = Routes.INFOSCREEN.route + "/{imageUrl}/{price}",
            arguments = listOf(
                navArgument("price") {
                    type = NavType.IntType
                },
                navArgument("imageUrl") {
                    type = NavType.StringType
                }
            )
        ) { args ->
            InfoScreen(
                imageUrl = args.arguments?.getString("imageUrl"),
                price = args.arguments?.getInt("price")
            )
        }

    }
}