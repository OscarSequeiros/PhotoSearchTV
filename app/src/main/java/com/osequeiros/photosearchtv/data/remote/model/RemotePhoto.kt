package com.osequeiros.photosearchtv.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePhoto(
    val id: String,
    val title: String,
    val datetaken: String,
    val ownername: String,
    val url_s: String?,
    val url_n: String?,
    val url_m: String?,
    val url_l: String?,
    val url_o: String?,
)