package com.example.sportprokg.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportprokg.R
import com.example.sportprokg.models.news.NewsItem
import kotlinx.android.synthetic.main.news_item.view.*
import org.jsoup.Jsoup

class NewsAdapter(
    private val listener: OnItemClickListener,
    val context: Context
) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var newsList = mutableListOf<NewsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]

        Glide.with(context)
            .load(currentItem.image)
            .centerCrop()
            .into(holder.newsImage)

        holder.newsTitle.text = Jsoup.parse(currentItem.title).text()
        holder.newsDate.text = currentItem.createdAt?.substring(0, 10)
        holder.newsSportType.text = currentItem.sportType?.sport
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val newsImage: ImageView = itemView.news_image
        val newsSportType: TextView = itemView.news_typeof_sport
        val newsTitle: TextView = itemView.news_title
        val newsDate: TextView = itemView.news_date

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

    fun setData(data: MutableList<NewsItem>) {
        this.newsList = data
        notifyDataSetChanged()
    }

    fun getArticle(position: Int): NewsItem {
        return newsList[position]
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}