package com.example.sportprokg.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.SportItem
import kotlinx.android.synthetic.main.filter_item.view.*

class FilterAdapter(
    private val onItemClickListener: OnItemClickListener,
    val context: Context
) : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {

    var sportsList = mutableListOf<SportItem>()

    fun setData(data: MutableList<SportItem>) {
        this.sportsList = data
        notifyDataSetChanged()
    }

    fun getSport(position: Int): SportItem {
        return sportsList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.filter_item, parent, false)
        return FilterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val currentItem = sportsList[position]

        holder.filterSport?.text = currentItem.sportName
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }

    inner class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val filterSport: TextView = itemView.filter_tv

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}