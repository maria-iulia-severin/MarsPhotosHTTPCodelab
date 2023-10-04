package com.example.marsphotos.network

import kotlinx.serialization.Serializable

@Serializable
data class MarsPhotoEntity(
    val id: String,
    val img_src: String
)

data class MarsPhoto(
    val id: String,
    val imageUrl: String
)
