package com.example.marsphotos.network

import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.Retrofit

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//build and create retrofit object

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}