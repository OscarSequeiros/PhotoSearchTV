package com.osequeiros.photosearchtv.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePhoto(
    val id: String,
    val title: String,
    val datetaken: String,
    val ownername: String,
    val url_q: String,
    val url_o: String,
)