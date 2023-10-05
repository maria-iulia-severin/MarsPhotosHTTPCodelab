package com.example.marsphotos.di.marsPhotos

import com.example.marsphotos.network.MarsPhoto

class GetMarsPhotosUseCase(
    private val getMarsPhotosRepository: GetMarsPhotosRepository
) {
    suspend fun getPhotos(): List<MarsPhoto> = getMarsPhotosRepository.getMarsPhotos()
}