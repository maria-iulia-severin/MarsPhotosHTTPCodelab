package com.example.marsphotos.network

import kotlinx.serialization.Serializable

@Serializable
data class TayAlbum (
    val album_id: Integer,
    val title: String,
    val release_date: String
    )