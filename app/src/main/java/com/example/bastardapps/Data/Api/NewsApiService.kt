package com.example.bastardapps.Data.Api

import com.example.bastardapps.Data.Model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "id",
        @Query("apiKey") apiKey: String = "GANTI_DENGAN_API_KEY_KAMU"
        // Daftar gratis di: https://newsapi.org/register
    ): NewsResponse
}