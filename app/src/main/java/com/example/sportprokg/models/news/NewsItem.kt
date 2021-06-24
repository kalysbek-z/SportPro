package com.example.sportprokg.models.news

import com.google.gson.annotations.SerializedName

data class NewsItem(
    @SerializedName("created_at")
    var createdAt: String?, // date of the article
    var image: String?,
    @SerializedName("text")
    var description: String?,
    var title: String?,
    var user: Int?,
    var sport_id : Int?
)