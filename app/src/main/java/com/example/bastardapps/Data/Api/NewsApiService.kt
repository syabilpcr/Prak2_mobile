package com.example.bastardapps.Data.Api

import com.example.bastardapps.Data.Model.NewsResponse
import retrofit2.http.GET

interface NewsApiService {
    @GET("posts")
    suspend fun getTopHeadlines(): NewsResponse

}