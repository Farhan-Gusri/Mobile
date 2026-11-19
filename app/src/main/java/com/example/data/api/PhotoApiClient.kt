package com.example.data.api

import com.example.data.model.PhotoModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotoApiService {
    @GET("v2/list")
    suspend fun getPhotos(): List<PhotoModel>
}

object PhotoApiClient {
    private const val BASE_URL = "https://picsum.photos/"

    val apiService: PhotoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApiService::class.java)
    }
}