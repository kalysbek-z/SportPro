package com.example.sportprokg.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportprokg.api.RequestInstance
import com.example.sportprokg.api.ServiceAPI
import com.example.sportprokg.models.news.NewsItem
import retrofit2.Call
import retrofit2.Response

class NewsViewModel(
) : ViewModel() {
    lateinit var newsList: MutableLiveData<MutableList<NewsItem>>

    init {
        newsList = MutableLiveData()
    }

    fun getNewsListObserver(): MutableLiveData<MutableList<NewsItem>> {
        return newsList
    }

    fun makeApiCall() {
        val instance = RequestInstance.getRetrofitInstance().create(ServiceAPI::class.java)
        val call = instance.getNews()
        call.enqueue(object : retrofit2.Callback<MutableList<NewsItem>> {
            override fun onFailure(call: Call<MutableList<NewsItem>>, t: Throwable) {
                newsList.postValue(null)
            }

            override fun onResponse(
                call: Call<MutableList<NewsItem>>,
                response: Response<MutableList<NewsItem>>
            ) {
                if (response.isSuccessful) {
                    newsList.postValue(response.body())
                } else {
                    newsList.postValue(null)
                }
            }
        })
    }
}