package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportprokg.api.RetrofitInstance
import com.example.sportprokg.api.ServiceAPI
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

//
//    fun getNewsListObserver(): MutableLiveData<MutableList<NewsItem>> {
//        return newsList
//    }
//
//    fun makeApiCall() {
//        val instance = RetrofitInstance.getRetrofitInstance().create(ServiceAPI::class.java)
//        val call = instance.getNews()
//        call.enqueue(object : retrofit2.Callback<MutableList<NewsItem>> {
//            override fun onFailure(call: Call<MutableList<NewsItem>>, t: Throwable) {
//                newsList.postValue(null)
//            }
//
//            override fun onResponse(
//                call: Call<MutableList<NewsItem>>,
//                response: Response<MutableList<NewsItem>>
//            ) {
//                if (response.isSuccessful) {
//                    newsList.postValue(response.body())
//                } else {
//                    newsList.postValue(null)
//                }
//            }
//        })
//    }
}