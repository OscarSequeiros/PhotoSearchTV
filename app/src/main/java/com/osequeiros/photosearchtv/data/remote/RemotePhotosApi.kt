package com.osequeiros.photosearchtv.data.remote

import com.osequeiros.photosearchtv.BuildConfig
import com.osequeiros.photosearchtv.data.remote.model.RemotePhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RemotePhotosApi {

    @GET("services/rest/?method=flickr.photos.getRecent&extras=date_taken,url_n,url_o,owner_name&&format=json&nojsoncallback=1")
    suspend fun recent(
        @Query("api_key") apiKey: String = BuildConfig.FLICKER_API_KEY
    ): RemotePhotosResponse

    @GET("services/rest/?method=flickr.photos.search&extras=date_taken,url_n,url_o,owner_name&&format=json&nojsoncallback=1")
    suspend fun search(
        @Query("api_key") apiKey: String = BuildConfig.FLICKER_API_KEY,
        @Query("text") value: String
    ): RemotePhotosResponse
}