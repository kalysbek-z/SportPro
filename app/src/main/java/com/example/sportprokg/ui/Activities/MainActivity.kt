package com.example.sportprokg.ui.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sportprokg.R
import com.example.sportprokg.Utilities.ConstValues
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SportProKG)
        setContentView(R.layout.activity_main)

        Log.d("tag", "Main activity created")

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)

        val intent = intent
        val activityKey = intent.getStringExtra("activity_key")
        when (activityKey) {
            ConstValues.COMPETITION_KEY ->
                bottomNavigationView.selectedItemId = R.id.competitionsFragment
            ConstValues.NEWS_KEY ->
                bottomNavigationView.selectedItemId = R.id.newsFragment
        }
    }
}