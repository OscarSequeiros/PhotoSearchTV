package com.osequeiros.photosearchtv.domain

import com.osequeiros.photosearchtv.domain.model.Photo

class SearchPhotosUseCase {

    operator fun invoke(value: String): List<Photo> {
        return emptyList()
    }
}