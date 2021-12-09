package com.osequeiros.photosearchtv.data.remote

import com.osequeiros.photosearchtv.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiFactory {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val queryInterceptor = Interceptor { chain ->
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(
                "extras",
                "date_taken,url_s,url_n,url_m,url_l,url_o,owner_name"
            )
            .addQueryParameter("format", "json")
            .addQueryParameter("nojsoncallback", "1")
            .addQueryParameter("api_key", BuildConfig.FLICKR_API_KEY)
            .build()
        val newRequest = request.newBuilder().url(url).build()

        chain.proceed(newRequest)

    }

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(queryInterceptor)
        .build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    companion object {
        const val BASE_URL = "https://www.flickr.com/"
    }
}