package com.example.marsphotos.di

import com.example.marsphotos.network.retrofit

val retrofitPhotosService: GetPhotosDataSource by lazy {
    retrofit.create(GetPhotosDataSource::class.java)
}
