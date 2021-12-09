package com.osequeiros.photosearchtv.di

import com.osequeiros.photosearchtv.data.PhotosDataRepository
import com.osequeiros.photosearchtv.data.remote.ApiFactory
import com.osequeiros.photosearchtv.data.remote.RemotePhotosApi
import com.osequeiros.photosearchtv.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun PhotosDataRepository.binds(): PhotosRepository

    companion object {

        @Provides
        fun provideApi(): RemotePhotosApi {
            return ApiFactory().retrofit().create(RemotePhotosApi::class.java)
        }
    }
}