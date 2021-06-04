package com.example.sportprokg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.NewsItem
import com.example.sportprokg.ui.fragments.NewsFragment

class NewsAdapter(
    private val newsList: List<NewsItem>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)

        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.sport?.text = newsList[position].sport
        holder.title?.text = newsList[position].title
        holder.date?.text = newsList[position].date

    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var sport: TextView = itemView.findViewById(R.id.news_typeof_sport)
        var title: TextView = itemView.findViewById(R.id.news_title)
        var date: TextView = itemView.findViewById(R.id.news_date)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}