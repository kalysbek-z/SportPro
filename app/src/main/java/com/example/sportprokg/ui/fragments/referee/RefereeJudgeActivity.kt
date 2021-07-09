package com.example.sportprokg.ui.fragments.referee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.activity_referee_judge.*

class RefereeJudgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referee_judge)

        referee_judge_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        var intent = intent
        val category = intent.getStringExtra("cat_key")
        referee_judge_category.text = category
    }
}