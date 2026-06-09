package com.example.bastardapps.Data.Model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles") val articles: List<NewsArticle>
)

data class NewsArticle(
    @SerializedName("title")       val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("urlToImage")  val urlToImage: String?,
    @SerializedName("url")         val url: String?,
    @SerializedName("publishedAt") val publishedAt: String?,
    @SerializedName("source")      val source: NewsSource?
)

data class NewsSource(
    @SerializedName("name") val name: String?
)