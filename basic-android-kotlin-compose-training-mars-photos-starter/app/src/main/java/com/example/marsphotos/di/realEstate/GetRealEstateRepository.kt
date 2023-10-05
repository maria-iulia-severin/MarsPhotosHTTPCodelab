package com.example.marsphotos.di.realEstate

import com.example.marsphotos.network.RealEstate

class GetRealEstateRepository(private val retrofitRealEstateService: GetRealEstateDataSource) {
    suspend fun getRealEstate(): List<RealEstate> =
        retrofitRealEstateService.getRealEstate().map { realEstateEntity ->
            RealEstate(
                price = realEstateEntity.price,
                id = realEstateEntity.id,
                type = realEstateEntity.type,
                imageUrl = realEstateEntity.img_src.replace("http","https")
            )
        }
}