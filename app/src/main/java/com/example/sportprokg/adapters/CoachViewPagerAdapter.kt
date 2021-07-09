package com.example.sportprokg.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportprokg.ui.fragments.coach.CoachCompetitionsFragment
import com.example.sportprokg.ui.fragments.coach.CoachInfoFragment
import com.example.sportprokg.ui.fragments.coach.CoachSportsmenFragment

class CoachViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                CoachInfoFragment()
            }
            1 -> {
                CoachCompetitionsFragment()
            }
            2 -> {
                CoachSportsmenFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}