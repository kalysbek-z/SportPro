package com.example.sportprokg.ui.fragments.competitions

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.R
import com.example.sportprokg.adapters.CompetitionsAdapter
import com.example.sportprokg.api.ServiceAPI
import com.example.sportprokg.models.CompetitionsItem
import com.example.sportprokg.models.NewsItem
import com.example.sportprokg.repository.CompetitionsRepository
import com.example.sportprokg.ui.Activities.DetailedCompetitionsActivity
import com.example.sportprokg.ui.fragments.competitions.detailedcompetitions.RegulationsFragment
import com.example.sportprokg.ui.viewmodels.CompetitionsViewModel
import com.example.sportprokg.ui.viewmodels.CompetitionsViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_competitions.*
import kotlinx.android.synthetic.main.fragment_competitions.view.*
import kotlinx.android.synthetic.main.fragment_news.view.*

class CompetitionsFragment : Fragment(), CompetitionsAdapter.OnItemClickListener {

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
        //toolbar for news with filter button
        val view = inflater.inflate(R.layout.fragment_competitions, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.competitions_toolbar)
        toolbar.inflateMenu(R.menu.filter_toolbar_menu)

        view.comp_progressbar.visibility = View.VISIBLE
        viewModel = ViewModelProvider(
            this,
            CompetitionsViewModelProviderFactory(CompetitionsRepository(retrofitService))
        ).get(CompetitionsViewModel::class.java)

        initRecyclerView(view)

        viewModel.competitionsList.observe(viewLifecycleOwner, Observer {
            compAdapter.setData(it)
            view.comp_progressbar.visibility = View.GONE
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            //???
        })
        viewModel.getAllCompetitions()

        return view
    }

    private fun initRecyclerView(view: View) {
        view.comp_recycler.layoutManager = LinearLayoutManager(requireContext())
        compAdapter = CompetitionsAdapter(this@CompetitionsFragment, requireContext())
        view.comp_recycler.adapter = compAdapter
        view.comp_recycler.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val selectedEvent: CompetitionsItem = compAdapter.getCompetition(position)

        var mTitle: String? = selectedEvent.title
        var mRegulation: String? = selectedEvent.regulation
        var mGrid: String? = selectedEvent.table

        val intent =
            Intent(this@CompetitionsFragment.context, DetailedCompetitionsActivity::class.java)
        intent.putExtra("title_key", mTitle)
        intent.putExtra("regulation_key", mRegulation)
        intent.putExtra("grid_key", mGrid)
        startActivity(intent)
    }
}