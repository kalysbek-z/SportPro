package com.example.sportprokg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.Utilities.ConstValues
import com.example.sportprokg.adapters.FilterAdapter
import com.example.sportprokg.api.ServiceAPI
import com.example.sportprokg.repository.FilterRepository
import com.example.sportprokg.ui.Activities.MainActivity
import com.example.sportprokg.ui.fragments.competitions.CompetitionsFragment
import com.example.sportprokg.ui.viewmodels.FilterViewModel
import com.example.sportprokg.ui.viewmodels.FilterViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_competitions_filter_type.*

class CompetitionsFilterTypeActivity : AppCompatActivity(), FilterAdapter.OnItemClickListener {
    lateinit var title: String
    lateinit var filterAdapter: FilterAdapter
    lateinit var viewModel: FilterViewModel

    private val retrofitServiceAPI = ServiceAPI.getInstance()

    var dataCommunicator: DataCommunicator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competitions_filter_type)
        setToolbarTitle()

        viewModel = ViewModelProvider(
            this,
            FilterViewModelProviderFactory(FilterRepository(retrofitServiceAPI))
        ).get(FilterViewModel::class.java)

        initRecyclerView()

        viewModel.sportsList.observe(this) {
            filterAdapter.setData(it)
        }

        when (title) {
            "Олимпийские виды спорта" ->
                viewModel.getSportsByType(1)
            "Национальные виды спорта" ->
                viewModel.getSportsByType(2)
            "Неолипийские виды спорта" ->
                viewModel.getSportsByType(3)
            "Виды спортов Пара и Сурдо (ЛОВЗ)" ->
                viewModel.getSportsByType(4)
        }
    }

    private fun initRecyclerView() {
        filterAdapter = FilterAdapter(this, this)
        comp_filter_recycler.apply {
            adapter = filterAdapter
            layoutManager = LinearLayoutManager(this@CompetitionsFilterTypeActivity)
        }
    }

    private fun setToolbarTitle() {
        var intent = intent
        title = intent.getStringExtra("title").toString()

        val toolbar = findViewById<Toolbar>(R.id.comp_filter_type_toolbar)
        toolbar.setTitle(title)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onItemClick(position: Int) {
        val sportId = filterAdapter.getSport(position).sportId
        val competitionsFragment = CompetitionsFragment()
        dataCommunicator = competitionsFragment as DataCommunicator
        if (sportId != null) {
            dataCommunicator?.sendData(sportId.toString())
        }

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("activity_key", ConstValues.COMPETITION_KEY)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
}