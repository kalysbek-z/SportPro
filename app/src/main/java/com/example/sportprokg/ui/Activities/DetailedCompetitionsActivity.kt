package com.example.sportprokg.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.sportprokg.DataCommunicator
import com.example.sportprokg.R
import com.example.sportprokg.adapters.DetailedCompetitionsViewPagerAdapter
import com.example.sportprokg.ui.fragments.competitions.detailedcompetitions.GridsFragment
import com.example.sportprokg.ui.fragments.competitions.detailedcompetitions.RegulationsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_detailed_competitions.*

class DetailedCompetitionsActivity : AppCompatActivity() {

    var dataCommunicatorRegulations: DataCommunicator? = null
    var dataCommunicatorGrids: DataCommunicator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_competitions)

        val tabLayout = findViewById<TabLayout>(R.id.det_comp_tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.det_comp_viewpager)
        viewPager.offscreenPageLimit = 5

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

        det_comp_toolbar.setNavigationIcon(R.drawable.ic_back)
        goBack()

        var intent = intent
        val mTitle = intent.getStringExtra("title_key")
        val mRegulation = intent.getStringExtra("regulation_key")
        val mGrid = intent.getStringExtra("grid_key")
        Log.d("tag", "det comp reg : $mRegulation")

        detailed_comp_title.text = mTitle

        val regulationsFragment = RegulationsFragment()
        dataCommunicatorRegulations = regulationsFragment as DataCommunicator
        if (mRegulation != null) {
            dataCommunicatorRegulations?.sendData(mRegulation)
        }

        val gridsFragment = GridsFragment()
        dataCommunicatorGrids = gridsFragment as DataCommunicator
        if (mGrid != null) {
            dataCommunicatorGrids?.sendData(mGrid)
        }
    }

    private fun goBack() {
        det_comp_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}