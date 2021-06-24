package com.example.sportprokg.api

import com.example.sportprokg.models.news.NewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {

    @GET("api/news/")
    fun getNews(): Call<MutableList<NewsItem>>

}