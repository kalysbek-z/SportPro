package com.example.sportprokg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_competitions_filter.*
import kotlinx.android.synthetic.main.activity_news_filter.*

class CompetitionsFilterActivity : AppCompatActivity() {
    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competitions_filter)
        sportCategoriesClickListeners()
        goBack()
    }

    private fun sportCategoriesClickListeners() {
        comp_national_sports_btn.setOnClickListener {
            title = comp_national_sports_tv.text.toString()
            Log.d("tag", title)
            val intent = Intent(this, CompetitionsFilterTypeActivity::class.java)
            intent.putExtra("title", "Национальные виды спорта")
            startActivity(intent)
        }

        comp_olympic_sports_btn.setOnClickListener {
            title = comp_olympic_sports_tv.text.toString()

            Log.d("tag", title)
            val intent = Intent(this, CompetitionsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        comp_not_olympic_sports_btn.setOnClickListener {
            title = comp_not_olympic_sports_tv.text.toString()
            Log.d("tag", title)
            val intent = Intent(this, CompetitionsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }

        comp_para_surdo_sports_btn.setOnClickListener {
            title = comp_para_surdo_sports_tv.text.toString()
            Log.d("tag", title)
            val intent = Intent(this, CompetitionsFilterTypeActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    private fun goBack() {
        comp_filter_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}