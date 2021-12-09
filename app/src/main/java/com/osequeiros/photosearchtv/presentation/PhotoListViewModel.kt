package com.osequeiros.photosearchtv.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osequeiros.photosearchtv.domain.GetRecentPhotosUseCase
import com.osequeiros.photosearchtv.domain.SearchPhotosUseCase
import com.osequeiros.photosearchtv.domain.model.Photo
import com.osequeiros.photosearchtv.presentation.userintent.PhotoListUserIntent
import com.osequeiros.photosearchtv.presentation.userintent.PhotoListUserIntent.*
import com.osequeiros.photosearchtv.presentation.viewstate.PhotoListViewState
import com.osequeiros.photosearchtv.presentation.viewstate.PhotoListViewState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getRecentPhotosUseCase: GetRecentPhotosUseCase,
    private val searchPhotosUseCase: SearchPhotosUseCase,
) : ViewModel() {

    fun process(userIntent: PhotoListUserIntent): Flow<PhotoListViewState> {
        return flow {
            when (userIntent) {
                is SeeRecentPhotosDefaultIntent -> {
                    val photos = getRecentPhotosUseCase()
                    emit(photos)
                }
                is SearchPhotosIntent -> {
                    val photos = searchPhotosUseCase(userIntent.value)
                    emit(photos)
                }
            }
        }
            .map { photos -> if (photos.isEmpty()) EmptyState else PhotosState(photos) }
            .catch { error -> emit(ErrorState(error)) }
            .onStart { emit(LoadingState) }
    }
}