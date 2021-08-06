package com.example.sportprokg.repository

import com.example.sportprokg.api.ServiceAPI

class FilterRepository constructor(private val retrofitServiceAPI: ServiceAPI) {
    fun getSportsByType(sportCategory: Int) = retrofitServiceAPI.getSportsByType(sportCategory)
}