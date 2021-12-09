package com.osequeiros.photosearchtv.data

import com.osequeiros.photosearchtv.data.mapper.DataPhotosMapper
import com.osequeiros.photosearchtv.data.remote.RemotePhotosApi
import com.osequeiros.photosearchtv.domain.model.Photo
import com.osequeiros.photosearchtv.domain.repository.PhotosRepository
import javax.inject.Inject

class PhotosDataRepository @Inject constructor(
    private val remoteSource: RemotePhotosApi,
    private val mapper: DataPhotosMapper,
) : PhotosRepository {

    override suspend fun search(value: String): List<Photo> {
        val remotePhotos = remoteSource.search(value).photos.photo
        return with(mapper) { remotePhotos.toDomain() }
    }

    override suspend fun getRecent(): List<Photo> {
        val remotePhotos = remoteSource.recent().photos.photo
        return with(mapper) { remotePhotos.toDomain() }
    }
}