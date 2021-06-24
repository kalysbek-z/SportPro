package com.example.sportprokg.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.sportprokg.R
import com.example.sportprokg.adapters.DetailedCompetitionsViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailedCompetitionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_competitions)

        val tabLayout = findViewById<TabLayout>(R.id.det_comp_tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.det_comp_viewpager)

        val viewPagerAdapter =
            DetailedCompetitionsViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Регламент"
                }
                1 -> {
                    tab.text = "Команда"
                }
                2 -> {
                    tab.text = "Участники"
                }
                3 -> {
                    tab.text = "Сетки"
                }
                4 -> {
                    tab.text = "Результаты"
                }
            }
        }.attach()
    }
}