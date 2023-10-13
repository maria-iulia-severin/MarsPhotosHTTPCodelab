package com.example.marsphotos.ui.screens.realEstateScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.di.realEstate.GetRealEstateUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class RealEstateViewModel(
    private val getRealEstateUseCase: GetRealEstateUseCase
) : ViewModel() {

    private var _realEstateUiState = MutableStateFlow(RealEstateUiState())
    val realEstateUiState: StateFlow<RealEstateUiState> = _realEstateUiState.asStateFlow()

    init {
        getRealEstatePrice()
    }

    fun savePosition(index: Int) {
        _realEstateUiState.update { currentState ->
            currentState.copy(selectedPosition = index)
        }
    }

    fun getSavedPosition() = _realEstateUiState.value.selectedPosition

    private fun getRealEstatePrice() {
        viewModelScope.launch {
            try {
                _realEstateUiState.update { currentState ->
                    currentState.copy(
                        realEstates = getRealEstateUseCase.getRealEstate(),
                        isLoading = false
                    )
                }
            } catch (e: IOException) {
                _realEstateUiState.update { currentState ->
                    currentState.copy(isError = true, isLoading = false)
                }
            }
        }
    }
}