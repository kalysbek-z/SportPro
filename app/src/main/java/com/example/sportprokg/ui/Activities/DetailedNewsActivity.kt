package com.example.sportprokg.ui.Activities

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.activity_detailed_news.*

class DetailedNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)

        var intent = intent
        val mTitle = intent.getStringExtra("title_key")
        val mImage = intent.getStringExtra("image_key")
        val mDate = intent.getStringExtra("date_key")
        val mDescription = intent.getStringExtra("description_key")

        detailed_news_title.text = mTitle

        Glide.with(this)
            .load(mImage)
            .centerCrop()
            .into(detailed_news_image)

        detailed_news_date.text = mDate?.substring(0, 10)
        detailed_news_content.text = mDescription
        goBack()
    }

    private fun goBack() {
        detailed_news_back.setOnClickListener {
            onBackPressed()
        }
    }
}