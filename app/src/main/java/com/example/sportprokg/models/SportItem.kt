package com.example.sportprokg.models

import com.google.gson.annotations.SerializedName

data class SportItem(
    @SerializedName("sports_id")
    var sportId: Int?,
    @SerializedName("title")
    var sportName: String?
)