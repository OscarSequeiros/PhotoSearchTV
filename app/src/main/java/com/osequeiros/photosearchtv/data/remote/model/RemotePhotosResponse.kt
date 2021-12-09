package com.osequeiros.photosearchtv.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePhotosResponse(
    val photos: RemotePhotos
) {

    @JsonClass(generateAdapter = true)
    data class RemotePhotos(
        val photo: List<RemotePhoto>
    )
}