package com.example.marsphotos.network

import kotlinx.serialization.Serializable

@Serializable
data class RealEstateEntity (
    val price: Int,
    val id: String,
    val type: String,
    val img_src: String
)

data class RealEstate(
    val price: Int,
    val id: String,
    val type: String,
    val imageUrl: String
)