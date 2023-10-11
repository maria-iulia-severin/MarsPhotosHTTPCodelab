package com.example.marsphotos.di

import com.example.marsphotos.di.marsPhotos.GetMarsPhotosUseCase
import com.example.marsphotos.di.marsPhotos.GetMarsPhotosDataSource
import com.example.marsphotos.di.marsPhotos.GetMarsPhotosRepository
import com.example.marsphotos.di.realEstate.GetRealEstateDataSource
import com.example.marsphotos.di.realEstate.GetRealEstateRepository
import com.example.marsphotos.di.realEstate.GetRealEstateUseCase
import com.example.marsphotos.network.retrofit
import com.example.marsphotos.ui.screens.marsPhotosScreen.MarsViewModel
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<GetMarsPhotosDataSource> { retrofit.create(GetMarsPhotosDataSource::class.java) }
    single {
        GetMarsPhotosRepository(get())
    }
    single { GetMarsPhotosUseCase(get()) }
    viewModel { MarsViewModel(get()) }

    single<GetRealEstateDataSource> { retrofit.create(GetRealEstateDataSource::class.java) }
    single { GetRealEstateRepository(get()) }
    single { GetRealEstateUseCase(get()) }
    viewModel { RealEstateViewModel(get()) }

}