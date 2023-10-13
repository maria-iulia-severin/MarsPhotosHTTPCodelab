package com.example.marsphotos.ui.screens.realEstateScreen

import com.example.marsphotos.network.RealEstate

data class RealEstateUiState(
    val realEstates: List<RealEstate> = listOf(),
    val isError: Boolean = false,
    val isLoading: Boolean = true,
    val selectedPosition: Int = -1
)