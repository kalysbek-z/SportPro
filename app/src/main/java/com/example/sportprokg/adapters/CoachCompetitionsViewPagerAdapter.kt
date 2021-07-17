package com.example.sportprokg.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportprokg.ui.fragments.coach.CoachAllCompetitionsFragment
import com.example.sportprokg.ui.fragments.coach.CoachMyCompetitionsFragment


class CoachCompetitionsViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                CoachAllCompetitionsFragment()
            }
            1 -> {
                CoachMyCompetitionsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}