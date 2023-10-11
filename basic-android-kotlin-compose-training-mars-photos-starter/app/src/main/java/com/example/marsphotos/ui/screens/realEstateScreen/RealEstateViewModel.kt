package com.example.marsphotos.ui.screens.realEstateScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.di.realEstate.GetRealEstateUseCase
import com.example.marsphotos.network.RealEstate
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface RealEstateUiState {
    data class Success(val realEstates: List<RealEstate>) : RealEstateUiState
    object Error : RealEstateUiState
    object Loading : RealEstateUiState
}

class RealEstateViewModel(
    private val getRealEstateUseCase: GetRealEstateUseCase
) : ViewModel() {
    var realEstateUiState: RealEstateUiState by mutableStateOf(RealEstateUiState.Loading)
        private set
    private var selectedPosition: Int by mutableIntStateOf(-1)

    init {
        getRealEstatePrice()
    }

    fun savePosition(index: Int) {
        selectedPosition = index
    }

    fun getSavedPosition() = selectedPosition

    private fun getRealEstatePrice() {
        viewModelScope.launch {
            realEstateUiState = try {
                val realEstates = getRealEstateUseCase.getRealEstate()
                RealEstateUiState.Success(realEstates)
            } catch (e: IOException) {
                RealEstateUiState.Error
            }
        }
    }
}