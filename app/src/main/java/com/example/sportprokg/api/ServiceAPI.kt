package com.example.sportprokg.api

import com.example.sportprokg.Utilities.ConstValues
import com.example.sportprokg.models.CompetitionsItem
import com.example.sportprokg.models.NewsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServiceAPI {

    //NEWS
    @GET("api/news/")
    fun getNews(): Call<MutableList<NewsItem>>

    //COMPETITIONS
    @GET("api/competitions/Competitions/")
    fun getCompetitions(): Call<MutableList<CompetitionsItem>>

    companion object {
        var retrofitServiceAPI: ServiceAPI? = null

        fun getInstance(): ServiceAPI {
            if (retrofitServiceAPI == null) {

                val retrofit = Retrofit.Builder()
                    .baseUrl(ConstValues.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitServiceAPI = retrofit.create(ServiceAPI::class.java)
            }
            return retrofitServiceAPI!!
        }
    }
}