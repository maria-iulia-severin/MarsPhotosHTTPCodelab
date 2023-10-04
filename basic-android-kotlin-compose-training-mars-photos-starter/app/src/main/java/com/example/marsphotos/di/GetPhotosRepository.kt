package com.example.marsphotos.di

import com.example.marsphotos.network.MarsPhoto

class GetPhotosRepository(private val retrofitPhotosService: GetPhotosDataSource) {
    suspend fun getPhotos(): List<MarsPhoto> =
        retrofitPhotosService.getPhotos().map { photoEntity ->
            MarsPhoto(
                id = photoEntity.id,
                imageUrl = photoEntity.img_src
            )
        }
}
