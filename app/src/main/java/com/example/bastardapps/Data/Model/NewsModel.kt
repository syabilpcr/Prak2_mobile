package com.example.bastardapps.Data.Model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("posts") val articles: List<NewsArticle>
)

data class NewsArticle(
    @SerializedName("title")  val title: String?,
    @SerializedName("body")   val description: String?,
    @SerializedName("tags")   val tags: List<String>?
)

data class NewsSource(
    @SerializedName("name") val name: String?
)