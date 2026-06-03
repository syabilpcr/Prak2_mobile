package com.example.bastardapps.Data.Api

import com.example.bastardapps.Data.Model.PhotoModel
import retrofit2.http.GET

    interface PhotoApiService {
        @GET("list")
        suspend fun getPhotos(): List<PhotoModel>
    }
