package com.example.sportprokg.ui.fragments.coach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportprokg.R
import com.example.sportprokg.adapters.CoachViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_coach_main.view.*

class CoachMainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coach_main, container, false)

        val tabLayout = view.coach_tab_layout
        val viewPager = view.coach_viewpager

        val viewPagerAdapter =
            CoachViewPagerAdapter(childFragmentManager, lifecycle)

        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Данные"
                }
                1 -> {
                    tab.text = "Соревнования"
                }
                2 -> {
                    tab.text = "Спортсмены"
                }
            }
        }.attach()

        return view
    }

}