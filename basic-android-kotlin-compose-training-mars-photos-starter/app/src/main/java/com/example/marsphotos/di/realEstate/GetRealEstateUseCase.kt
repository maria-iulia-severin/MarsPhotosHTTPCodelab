package com.example.marsphotos.di.realEstate

import com.example.marsphotos.network.RealEstate


class GetRealEstateUseCase(
    private val getRealEstateRepository: GetRealEstateRepository
) {
    suspend fun getRealEstate(): List<RealEstate> = getRealEstateRepository.getRealEstate()
}