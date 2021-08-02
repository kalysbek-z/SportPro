package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportprokg.models.CompetitionsItem
import com.example.sportprokg.repository.CompetitionsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompetitionsViewModel(
    private val repository: CompetitionsRepository
) : ViewModel() {
    var competitionsList: MutableLiveData<MutableList<CompetitionsItem>> = MutableLiveData()
    var errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getAllCompetitions() {
        val response = repository.getAllCompetitions()

        response.enqueue(object : Callback<MutableList<CompetitionsItem>> {
            override fun onFailure(call: Call<MutableList<CompetitionsItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

            override fun onResponse(
                call: Call<MutableList<CompetitionsItem>>,
                response: Response<MutableList<CompetitionsItem>>
            ) {
                competitionsList.postValue(response.body())
            }
        })
    }
}