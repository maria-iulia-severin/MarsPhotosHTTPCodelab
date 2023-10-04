package com.example.marsphotos.di

import com.example.marsphotos.network.MarsPhotoEntity
import retrofit2.http.GET

interface GetPhotosDataSource {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhotoEntity>
}
