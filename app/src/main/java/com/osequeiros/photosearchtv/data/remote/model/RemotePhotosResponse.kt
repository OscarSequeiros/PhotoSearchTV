package com.osequeiros.photosearchtv.data.remote.model

data class RemotePhotosResponse(
    val photos: RemotePhotos
) {

    data class RemotePhotos(
        val photo: List<RemotePhoto>
    )
}