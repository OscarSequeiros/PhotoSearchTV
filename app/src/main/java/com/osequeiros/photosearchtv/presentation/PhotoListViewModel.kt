package com.osequeiros.photosearchtv.presentation

import androidx.lifecycle.ViewModel
import com.osequeiros.photosearchtv.domain.GetRecentPhotosUseCase
import com.osequeiros.photosearchtv.domain.SearchPhotosUseCase
import com.osequeiros.photosearchtv.domain.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getRecentPhotosUseCase: GetRecentPhotosUseCase,
    private val searchPhotosUseCase: SearchPhotosUseCase,
) : ViewModel() {

    suspend fun getRecent(): List<Photo> {
        return getRecentPhotosUseCase()
    }

    suspend fun search(value: String): List<Photo> {
        return searchPhotosUseCase(value)
    }
}