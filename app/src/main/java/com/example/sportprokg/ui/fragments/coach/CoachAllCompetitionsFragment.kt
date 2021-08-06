package com.example.sportprokg.ui.fragments.coach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.R
import com.example.sportprokg.adapters.CompetitionsAdapter
import com.example.sportprokg.api.ServiceAPI
import com.example.sportprokg.repository.CompetitionsRepository
import com.example.sportprokg.ui.viewmodels.CompetitionsViewModel
import com.example.sportprokg.ui.viewmodels.CompetitionsViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_coach_all_competitions.view.*
import kotlinx.android.synthetic.main.fragment_competitions.view.*

class CoachAllCompetitionsFragment : Fragment() {

    lateinit var compAdapter: CompetitionsAdapter
    lateinit var viewModel: CompetitionsViewModel

    private val retrofitService = ServiceAPI.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coach_all_competitions, container, false)

        viewModel = ViewModelProvider(
            this,
            CompetitionsViewModelProviderFactory(CompetitionsRepository(retrofitService))
        ).get(CompetitionsViewModel::class.java)

        initRecyclerView(view)

        viewModel.competitionsList.observe(viewLifecycleOwner, Observer {
            compAdapter.setData(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            //???
        })

        viewModel.getAllCompetitions()

        return view
    }

    private fun initRecyclerView(view: View) {
        view.coach_all_comp_recycler.layoutManager = LinearLayoutManager(requireContext())
        compAdapter = CompetitionsAdapter(requireContext())
        view.coach_all_comp_recycler.adapter = compAdapter
        view.coach_all_comp_recycler.setHasFixedSize(true)
    }
}