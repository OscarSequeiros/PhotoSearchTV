package com.osequeiros.photosearchtv.domain

import com.osequeiros.photosearchtv.domain.model.Photo
import com.osequeiros.photosearchtv.domain.repository.PhotosRepository
import javax.inject.Inject

class SearchPhotosUseCase @Inject constructor(
    private val repository: PhotosRepository
) {

    suspend operator fun invoke(value: String): List<Photo> {
        return repository.search(value)
    }
}