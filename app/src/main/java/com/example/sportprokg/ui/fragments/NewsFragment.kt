package com.example.sportprokg.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.ui.Activities.DetailedNewsActivity
import com.example.sportprokg.R
import com.example.sportprokg.adapters.NewsAdapter
import com.example.sportprokg.api.RequestInstance
import com.example.sportprokg.api.ServiceAPI
import com.example.sportprokg.models.news.NewsItem
import com.example.sportprokg.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*
import retrofit2.Call
import retrofit2.Response

class NewsFragment : Fragment(), NewsAdapter.OnItemClickListener {

    lateinit var newsAdapter: NewsAdapter

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

        initRecyclerView(view)
        getNews(view)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onItemClick(position: Int) {
        

        val intent = Intent(requireContext(), DetailedNewsActivity::class.java)
        startActivity(intent)
    }

    private fun initRecyclerView(view: View) {
        view.news_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        newsAdapter = NewsAdapter(this@NewsFragment, requireContext())
        view.news_recyclerview.adapter = newsAdapter
        view.news_recyclerview.setHasFixedSize(true)
    }

    fun getNews(view: View) {
        val viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.getNewsListObserver().observe(viewLifecycleOwner, Observer<MutableList<NewsItem>> {
            if (it != null) {
                newsAdapter.setData(it as MutableList<NewsItem>)
                newsAdapter.notifyDataSetChanged()
            } else {

            }
        })
        viewModel.makeApiCall()
    }
}

