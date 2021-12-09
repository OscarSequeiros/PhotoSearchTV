package com.osequeiros.photosearchtv.presentation.viewstate

import com.osequeiros.photosearchtv.domain.model.Photo

sealed class PhotoListViewState {

    object LoadingState : PhotoListViewState()

    data class PhotosState(val photos: List<Photo>) : PhotoListViewState()

    object EmptyState : PhotoListViewState()

    data class ErrorState(val error: Throwable) : PhotoListViewState()
}