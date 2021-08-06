package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportprokg.models.SportItem
import com.example.sportprokg.repository.FilterRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterViewModel(
    private val repository: FilterRepository
) : ViewModel() {
    var sportsList: MutableLiveData<MutableList<SportItem>> = MutableLiveData()

    fun getSportsByType(sportCategory: Int) {
        val response = repository.getSportsByType(sportCategory)

        response.enqueue(object : Callback<MutableList<SportItem>> {
            override fun onResponse(
                call: Call<MutableList<SportItem>>,
                response: Response<MutableList<SportItem>>
            ) {
                sportsList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<SportItem>>, t: Throwable) {
            }
        })
    }
}