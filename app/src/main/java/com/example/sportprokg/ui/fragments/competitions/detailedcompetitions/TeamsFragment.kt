package com.example.sportprokg.ui.fragments.competitions.detailedcompetitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.R
import com.example.sportprokg.adapters.DetailedCompetitionsTeamsAdapter
import com.example.sportprokg.models.CompetitionsItem
import com.example.sportprokg.models.TeamItem
import kotlinx.android.synthetic.main.fragment_teams.view.*


class TeamsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_teams, container, false)

        view.det_comp_teams_table_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        view.det_comp_teams_table_recyclerview.adapter = DetailedCompetitionsTeamsAdapter(dummyData())
        view.det_comp_teams_table_recyclerview.setHasFixedSize(true)

        return view
    }

    private fun dummyData(): List<TeamItem> {
        val list = mutableListOf<TeamItem>()

        list.add(
            TeamItem(
                1,
                "Бишкек",
                "Федерация Таэквондо Кыргызской Республики",
                "12"
            )
        )
        list.add(
            TeamItem(
                1,
                "Бишкек",
                "Федерация Таэквондо Кыргызской Республики",
                "12"
            )
        )
        list.add(
            TeamItem(
                1,
                "Бишкек",
                "Федерация Таэквондо Кыргызской Республики",
                "12"
            )
        )
        list.add(
            TeamItem(
                1,
                "Бишкек",
                "Федерация Таэквондо Кыргызской Республики",
                "12"
            )
        )
        list.add(
            TeamItem(
                1,
                "Бишкек",
                "Федерация Таэквондо Кыргызской Республики",
                "12"
            )
        )
        list.add(
            TeamItem(
                1,
                "Бишкек",
                "Федерация Таэквондо Кыргызской Республики",
                "12"
            )
        )

        return list
    }

}