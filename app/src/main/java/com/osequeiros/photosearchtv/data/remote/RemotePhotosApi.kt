package com.osequeiros.photosearchtv.data.remote

import com.osequeiros.photosearchtv.data.remote.model.RemotePhotosResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RemotePhotosApi {

    //?method=flickr.photos.getRecent&api_key=b6cb1608a7baa2e74fc6787d410bc0de&extras=date_taken,url_q,owner_name&format=json&nojsoncallback=1
    @GET("/?method=flickr.photos.getRecent&api_key=b6cb1608a7baa2e74fc6787d410bc0de&extras=date_taken,url_q,url_o,owner_name&&format=json&nojsoncallback=1")
    suspend fun recent(): RemotePhotosResponse

    @GET("/?method=flickr.photos.search&api_key=b6cb1608a7baa2e74fc6787d410bc0de&extras=date_taken,url_q,url_o,owner_name&&format=json&nojsoncallback=1&text={value}")
    suspend fun search(@Path("value") value: String): RemotePhotosResponse
}