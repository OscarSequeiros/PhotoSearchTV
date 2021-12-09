package com.osequeiros.photosearchtv.domain.model

data class Photo(
    val id: String,
    val title: String,
    val authorName: String,
    val datePublished: String,
    val thumbnailUrl: String,
    val highResolutionUrl: String,
)