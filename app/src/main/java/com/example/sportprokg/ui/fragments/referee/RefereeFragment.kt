package com.example.sportprokg.ui.fragments.referee

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.R
import com.example.sportprokg.ui.Activities.RefereeCompetitionActivity
import com.example.sportprokg.adapters.RefereeAdapter
import com.example.sportprokg.models.CompetitionsItem
import kotlinx.android.synthetic.main.fragment_referee.view.*

class RefereeFragment : Fragment(), RefereeAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_referee, container, false)

        view.referee_comp_recycler.layoutManager = LinearLayoutManager(requireContext())
        view.referee_comp_recycler.adapter =
            RefereeAdapter(dummyData(), this@RefereeFragment)
        view.referee_comp_recycler.setHasFixedSize(true)



        return view
    }

    override fun onItemClick(position: Int) {
        val intent =
            Intent(this@RefereeFragment.context, RefereeCompetitionActivity::class.java)
        startActivity(intent)
    }

    private fun dummyData(): List<CompetitionsItem> {
        val list = mutableListOf<CompetitionsItem>()

        list.add(
            CompetitionsItem(
                "Таэквондо",
                "регистрация открыта",
                "Открытое первенство по Таэквондо",
                "01.01.2021",
                "01.01.2021"
            )
        )
        list.add(
            CompetitionsItem(
                "Таэквондо",
                "регистрация открыта",
                "Открытое первенство по Таэквондо",
                "01.01.2021",
                "01.01.2021"
            )
        )
        list.add(
            CompetitionsItem(
                "Таэквондо",
                "регистрация открыта",
                "Открытое первенство по Таэквондо",
                "01.01.2021",
                "01.01.2021"
            )
        )
        list.add(
            CompetitionsItem(
                "Таэквондо",
                "регистрация открыта",
                "Открытое первенство по Таэквондо",
                "01.01.2021",
                "01.01.2021"
            )
        )
        list.add(
            CompetitionsItem(
                "Таэквондо",
                "регистрация открыта",
                "Открытое первенство по Таэквондо",
                "01.01.2021",
                "01.01.2021"
            )
        )
        list.add(
            CompetitionsItem(
                "Таэквондо",
                "регистрация открыта",
                "Открытое первенство по Таэквондо",
                "01.01.2021",
                "01.01.2021"
            )
        )

        return list
    }
}