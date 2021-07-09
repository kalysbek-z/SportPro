package com.example.sportprokg.ui.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportprokg.R
import com.example.sportprokg.ui.fragments.referee.RefereeChooseCategoryActivity
import kotlinx.android.synthetic.main.activity_referee_competition.*

class RefereeCompetitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referee_competition)

        referee_comp_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        referee_comp_btn.setOnClickListener {
            val intent =
                Intent(this, RefereeChooseCategoryActivity::class.java)
            startActivity(intent)
        }
    }
}