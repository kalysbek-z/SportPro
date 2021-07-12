package com.example.sportprokg.repository

import com.example.sportprokg.api.ServiceAPI

class NewsRepository constructor(private val retrofitServiceAPI : ServiceAPI) {

    fun getAllNews() = retrofitServiceAPI.getNews()
}