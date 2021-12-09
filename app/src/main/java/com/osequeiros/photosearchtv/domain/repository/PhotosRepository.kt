package com.osequeiros.photosearchtv.domain.repository

import com.osequeiros.photosearchtv.domain.model.Photo

interface PhotosRepository {

    fun search(value: String): List<Photo>

    fun getRecent(): List<Photo>
}