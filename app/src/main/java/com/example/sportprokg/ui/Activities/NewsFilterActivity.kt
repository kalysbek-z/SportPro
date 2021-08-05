package com.example.sportprokg.ui.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.activity_news_filter.*

class NewsFilterActivity : AppCompatActivity() {

    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_filter)

        sportCategoriesClickListeners()

        goBack()
    }

    private fun sportCategoriesClickListeners() {
        national_sports_btn.setOnClickListener {
            title = national_sports_tv.text.toString()

            val intent = Intent(this, NewsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        olympic_sports_btn.setOnClickListener {
            title = olympic_sports_tv.text.toString()

            val intent = Intent(this, NewsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        not_olympic_sports_btn.setOnClickListener {
            title = not_olympic_sports_tv.text.toString()

            val intent = Intent(this, NewsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        para_surdo_sports_btn.setOnClickListener {
            title = para_surdo_sports_tv.text.toString()

            val intent = Intent(this, NewsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    private fun goBack() {
        news_filter_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}