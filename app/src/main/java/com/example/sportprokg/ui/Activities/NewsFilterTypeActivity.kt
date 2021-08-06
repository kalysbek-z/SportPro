package com.example.sportprokg.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.sportprokg.R

class NewsFilterTypeActivity : AppCompatActivity() {
    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_filter_type)
        setToolbarTitle()
    }

    private fun setToolbarTitle() {
        var intent = intent
        title = intent.getStringExtra("title").toString()

        val toolbar = findViewById<Toolbar>(R.id.news_filter_type_toolbar)
        toolbar.setTitle(title)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}