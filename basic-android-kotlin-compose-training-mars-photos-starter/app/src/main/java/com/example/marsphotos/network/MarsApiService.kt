package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
private const val BASE_URL_TAY = "https://taylor-swift-api.sarbo.workers.dev"

//build and create retrofit object

val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

private val retrofit_tay = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL_TAY)
    .build()

interface TayApiService {
    @GET("albums")
    suspend fun getAlbums(): List<TayAlbum>
}

object TayApi {
    val retrofitServiceTay: TayApiService by lazy {
        retrofit_tay.create(TayApiService::class.java)
    }
}
