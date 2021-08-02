package com.example.sportprokg.repository

import com.example.sportprokg.api.ServiceAPI

class CompetitionsRepository constructor(private val retrofitServiceAPI: ServiceAPI) {
    fun getAllCompetitions() = retrofitServiceAPI.getCompetitions()
}