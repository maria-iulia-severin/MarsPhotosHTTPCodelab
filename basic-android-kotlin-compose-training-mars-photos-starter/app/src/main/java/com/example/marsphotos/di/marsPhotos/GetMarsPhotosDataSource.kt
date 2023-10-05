package com.example.marsphotos.di.marsPhotos

import com.example.marsphotos.network.MarsPhotoEntity
import retrofit2.http.GET

interface GetMarsPhotosDataSource {
    @GET("photos")
    suspend fun getMarsPhotos(): List<MarsPhotoEntity>
}
