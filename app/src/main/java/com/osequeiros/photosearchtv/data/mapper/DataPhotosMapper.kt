package com.osequeiros.photosearchtv.data.mapper

import com.osequeiros.photosearchtv.data.remote.model.RemotePhoto
import com.osequeiros.photosearchtv.domain.model.Photo
import javax.inject.Inject

class DataPhotosMapper @Inject constructor() {

    fun List<RemotePhoto>.toDomain(): List<Photo> {
        return map { remotePhoto -> remotePhoto.toDomain() }
    }

    private fun RemotePhoto.toDomain(): Photo {
        return Photo(
            id = id,
            title = title,
            authorName = ownername,
            datePublished = datetaken,
            thumbnailUrl = url_s ?: url_n ?: url_m.orEmpty(),
            highResolutionUrl = url_o ?: url_l ?: url_m.orEmpty(),
        )
    }
}