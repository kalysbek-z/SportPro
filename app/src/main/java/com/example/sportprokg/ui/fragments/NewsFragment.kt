package com.example.sportprokg.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.ui.DetailedNewsActivity
import com.example.sportprokg.R
import com.example.sportprokg.adapters.NewsAdapter
import com.example.sportprokg.models.NewsItem
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : Fragment(), NewsAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //toolbar for news with filter button
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.news_toolbar)
        toolbar.inflateMenu(R.menu.filter_toolbar_menu)

        view.news_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        view.news_recyclerview.adapter =
            NewsAdapter(dummyData(), this)
        view.news_recyclerview.setHasFixedSize(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onItemClick(position: Int) {
        val intent = Intent(this@NewsFragment.context, DetailedNewsActivity::class.java)
        startActivity(intent)
    }

    private fun dummyData(): List<NewsItem> {
        val list = mutableListOf<NewsItem>()

        list.add(
            NewsItem(
                "баскетбол",
                "какая-то новость",
                "01.01.2021"
            )
        )
        list.add(
            NewsItem(
                "футбол",
                "какая-то новость",
                "01.01.2021"
            )
        )
        list.add(
            NewsItem(
                "ушу",
                "какая-то новость",
                "01.01.2021"
            )
        )
        list.add(
            NewsItem(
                "дота 2",
                "какая-то новость",
                "01.01.2021"
            )
        )
        list.add(
            NewsItem(
                "баскетбол",
                "какая-то новость",
                "01.01.2021"
            )
        )

        return list
    }
}

