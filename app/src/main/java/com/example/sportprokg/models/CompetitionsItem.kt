package com.example.sportprokg.models

import com.google.gson.annotations.SerializedName

data class CompetitionsItem(
    var image: String?,
    var title: String?,
    var place: String?,
    @SerializedName("start_date")
    var startDate: String?,
    @SerializedName("finish_date")
    var finishDate: String?,
    var status: String?,
    @SerializedName("competitions_regulations_file")
    var regulation: String?,
    @SerializedName("league_table_file")
    var table: String?,
    @SerializedName("sport")
    var sportType: Sport?
)