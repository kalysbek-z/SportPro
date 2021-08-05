package com.example.sportprokg.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsItem(
    @SerializedName("created_at")
    var createdAt: String?, // date of the article
    var image: String?,
    @SerializedName("text")
    var description: String?,
    var title: String?,
    var user: Int?,
    @SerializedName("sport")
    var sportType : Sport?
)

public class Sport {
    @SerializedName("title")
    @Expose
    var sport: String? = null
}