package com.example.sportprokg.ui.fragments.competitions.detailedcompetitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.R
import com.example.sportprokg.adapters.DetailedCompetitionsResultsAdapter
import com.example.sportprokg.adapters.DetailedCompetitionsTeamsAdapter
import com.example.sportprokg.models.ResultItem
import com.example.sportprokg.models.TeamItem
import kotlinx.android.synthetic.main.fragment_results.view.*
import kotlinx.android.synthetic.main.fragment_teams.view.*

class ResultsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_results, container, false)

        view.results_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        view.results_recyclerview.adapter = DetailedCompetitionsResultsAdapter(dummyData())
        view.results_recyclerview.setHasFixedSize(true)

        return view
    }

    private fun dummyData(): List<ResultItem> {
        val list = mutableListOf<ResultItem>()

        list.add(
            ResultItem(
                1,
                "Name name",
                30,
                60,
                "Бишкек",
                "WorldClass"
            )
        )

        return list
    }
}