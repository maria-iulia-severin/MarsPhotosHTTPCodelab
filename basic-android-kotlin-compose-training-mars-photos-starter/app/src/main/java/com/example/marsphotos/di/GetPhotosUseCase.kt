package com.example.marsphotos.di

import com.example.marsphotos.network.MarsPhoto

class GetPhotosUseCase(
    private val getPhotosRepository: GetPhotosRepository
) {
    suspend fun getPhotos(): List<MarsPhoto> = getPhotosRepository.getPhotos()
}
