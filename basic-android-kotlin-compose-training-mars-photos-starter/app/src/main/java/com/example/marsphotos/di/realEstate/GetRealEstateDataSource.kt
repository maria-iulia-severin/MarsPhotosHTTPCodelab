package com.example.marsphotos.di.realEstate

import com.example.marsphotos.network.RealEstateEntity
import retrofit2.http.GET

interface GetRealEstateDataSource {
    @GET("realestate")
    suspend fun getRealEstate(): List<RealEstateEntity>
}