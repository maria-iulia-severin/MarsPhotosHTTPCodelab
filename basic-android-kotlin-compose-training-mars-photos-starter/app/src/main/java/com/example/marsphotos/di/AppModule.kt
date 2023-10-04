package com.example.marsphotos.di

import com.example.marsphotos.network.retrofit
import com.example.marsphotos.ui.screens.MarsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<GetPhotosDataSource>{retrofit.create(GetPhotosDataSource::class.java)}
    single {
        GetPhotosRepository(get())
    }
    // single<MarsPhotoEntity> { GetPhotosUseCase(get()) }
    single { GetPhotosUseCase(get()) }
    viewModel { MarsViewModel(get()) }
    // din MArsPhotoAPp -> val marsViewModel = MarsViewModel(GetPhotosUseCase(GetPhotosRepository(retrofitPhotosService)))
    //primul single imi reprezinta type ul pt retrofit.create si ce vreau eu sa fac
}