package com.osequeiros.photosearchtv.data

import com.osequeiros.photosearchtv.domain.model.Photo
import com.osequeiros.photosearchtv.domain.repository.PhotosRepository

class PhotosDataRepository : PhotosRepository {

    override fun search(value: String): List<Photo> {
        TODO("Not yet implemented")
    }

    override fun getRecent(): List<Photo> {
        TODO("Not yet implemented")
    }
}