package com.osequeiros.photosearchtv.presentation.userintent

sealed class PhotoListUserIntent {

    object SeeRecentPhotosDefaultIntent : PhotoListUserIntent()

    data class SearchPhotosIntent(val value: String): PhotoListUserIntent()
}