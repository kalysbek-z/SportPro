package com.example.sportprokg.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.R
import com.example.sportprokg.adapters.CompetitionsAdapter
import com.example.sportprokg.adapters.NewsAdapter
import com.example.sportprokg.models.CompetitionsItem
import com.example.sportprokg.models.NewsItem
import kotlinx.android.synthetic.main.fragment_competitions.view.*
import kotlinx.android.synthetic.main.fragment_news.view.*

class CompetitionsFragment : Fragment() {

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

        view.comp_recycler.layoutManager = LinearLayoutManager(requireContext())
        view.comp_recycler.adapter =
            CompetitionsAdapter(dummyData())
        view.comp_recycler.setHasFixedSize(true)

        return view
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