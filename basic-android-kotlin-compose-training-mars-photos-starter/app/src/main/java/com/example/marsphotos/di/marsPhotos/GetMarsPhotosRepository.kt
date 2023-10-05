package com.example.marsphotos.di.marsPhotos

import com.example.marsphotos.network.MarsPhoto

class GetMarsPhotosRepository(private val retrofitPhotosService: GetMarsPhotosDataSource) {
    suspend fun getMarsPhotos(): List<MarsPhoto> =
        retrofitPhotosService.getMarsPhotos().map { photoEntity ->
            MarsPhoto(
                id = photoEntity.id,
                imageUrl = photoEntity.img_src
            )
        }
}
