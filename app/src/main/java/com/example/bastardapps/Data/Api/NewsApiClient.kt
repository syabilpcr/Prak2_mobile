package com.example.bastardapps.Data.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiClient {
    // Menggunakan NewsAPI.org - daftar gratis di newsapi.org untuk API key
    // Alternatif gratis tanpa key: https://gnews.io atau https://currentsapi.services
    private const val BASE_URL = "https://newsapi.org/v2/"

    val apiService: NewsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}