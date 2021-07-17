package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportprokg.models.news.NewsItem
import com.example.sportprokg.repository.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    var newsList: MutableLiveData<MutableList<NewsItem>> = MutableLiveData()

    var errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getAllNews() {
        val response = repository.getAllNews()

        response.enqueue(object : Callback<MutableList<NewsItem>> {
            override fun onFailure(call: Call<MutableList<NewsItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

            override fun onResponse(
                call: Call<MutableList<NewsItem>>,
                response: Response<MutableList<NewsItem>>
            ) {
                newsList.postValue(response.body())
            }

        })
    }
}