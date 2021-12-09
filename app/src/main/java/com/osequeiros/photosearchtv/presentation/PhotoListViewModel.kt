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

    private val _state = MutableStateFlow<PhotoListViewState>(LoadingState)

    val state: StateFlow<PhotoListViewState>
        get() = _state

    fun process(userIntent: PhotoListUserIntent) {
        viewModelScope.launch {
            flow {
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
                .map { newState -> _state.value = newState }
                .onStart { _state.value = LoadingState }
                .catch { error -> _state.value = ErrorState(error) }
                .collect()
        }
    }
}