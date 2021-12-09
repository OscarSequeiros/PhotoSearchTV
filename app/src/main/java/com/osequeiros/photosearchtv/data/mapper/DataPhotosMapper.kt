package com.osequeiros.photosearchtv.data.mapper

import com.osequeiros.photosearchtv.data.remote.model.RemotePhoto
import com.osequeiros.photosearchtv.domain.model.Photo

class DataPhotosMapper {

    fun List<RemotePhoto>.toDomain(): List<Photo> {
        return map { remotePhoto -> remotePhoto.toDomain() }
    }

    private fun RemotePhoto.toDomain(): Photo {
        return Photo(
            id = id,
            title = title,
            authorName = ownername,
            datePublished = datetaken,
            thumbnailUrl = url_q,
            highResolutionUrl = url_o
        )
    }
}