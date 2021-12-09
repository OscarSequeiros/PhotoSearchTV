package com.osequeiros.photosearchtv.domain.repository

import com.osequeiros.photosearchtv.domain.model.Photo

interface PhotosRepository {

    suspend fun search(value: String): List<Photo>

    suspend fun getRecent(): List<Photo>
}