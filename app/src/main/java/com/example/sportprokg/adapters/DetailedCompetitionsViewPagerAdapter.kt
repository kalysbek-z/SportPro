package com.example.sportprokg.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportprokg.ui.fragments.competitions.detailedcompetitions.*

class DetailedCompetitionsViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                RegulationsFragment()
            }
            1 -> {
                TeamsFragment()
            }
            2 -> {
                ParticipantsFragment()
            }
            3 -> {
                GridsFragment()
            }
            4 -> {
                ResultsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}