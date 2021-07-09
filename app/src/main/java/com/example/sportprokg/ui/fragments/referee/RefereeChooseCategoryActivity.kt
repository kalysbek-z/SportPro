package com.example.sportprokg.ui.fragments.referee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.activity_referee_choose_category.*

class RefereeChooseCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referee_choose_category)

        referee_category_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        referee_category_adults.setOnClickListener {
            var category = referee_category_adults.text
            val intent =
                Intent(this, RefereeJudgeActivity::class.java)

            intent.putExtra("cat_key", category)
            startActivity(intent)
        }

        referee_category_juniors.setOnClickListener {
            var category = referee_category_juniors.text
            val intent =
                Intent(this, RefereeJudgeActivity::class.java)
            intent.putExtra("cat_key", category)
            startActivity(intent)
        }

        referee_category_cadets.setOnClickListener {
            var category = referee_category_cadets.text
            val intent =
                Intent(this, RefereeJudgeActivity::class.java)
            intent.putExtra("cat_key", category)
            startActivity(intent)
        }

        referee_category_kids1.setOnClickListener {
            var category = referee_category_kids1.text
            val intent =
                Intent(this, RefereeJudgeActivity::class.java)
            intent.putExtra("cat_key", category)
            startActivity(intent)
        }

        referee_category_kids2.setOnClickListener {
            var category = referee_category_kids2.text
            val intent =
                Intent(this, RefereeJudgeActivity::class.java)
            intent.putExtra("cat_key", category)
            startActivity(intent)
        }

        referee_category_kids3.setOnClickListener {
            var category = referee_category_kids3.text
            val intent =
                Intent(this, RefereeJudgeActivity::class.java)
            intent.putExtra("cat_key", category)
            startActivity(intent)
        }
    }
}