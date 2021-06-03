package com.example.sportprokg.news.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: NewsAdapter

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
        toolbar.inflateMenu(R.menu.news_toolbar_menu)

        //dummy data for recycler
//        val list = ArrayList<NewsItem>()
//
//        val img = R.drawable.news_sample_img
//        val sport = "Баскетбол"
//        val title = "Баер снизит стоимость Кая Хаверца"
//        val date = "03.06.2021"
//        var it = NewsItem(img, sport, title, date)
//        list.add(it)
//
//        recyclerView = view.findViewById<RecyclerView>(R.id.news_recyclerview)
//        mAdapter = NewsAdapter(list)
//        recyclerView.adapter = mAdapter
//        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.news_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}

