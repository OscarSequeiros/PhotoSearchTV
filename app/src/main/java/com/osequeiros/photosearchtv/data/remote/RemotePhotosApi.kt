package com.osequeiros.photosearchtv.data.remote

import com.osequeiros.photosearchtv.data.remote.model.RemotePhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RemotePhotosApi {

    @GET("services/rest/?method=flickr.photos.getRecent")
    suspend fun recent(): RemotePhotosResponse

    @GET("services/rest/?method=flickr.photos.search")
    suspend fun search(@Query("text") value: String): RemotePhotosResponse
}