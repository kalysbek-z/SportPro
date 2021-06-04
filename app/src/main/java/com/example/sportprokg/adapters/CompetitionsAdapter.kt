package com.example.sportprokg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.CompetitionsItem

class CompetitionsAdapter(private val compList: List<CompetitionsItem>) :
    RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder>() {

    inner class CompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sport: TextView = itemView.findViewById(R.id.comp_typeof_sport)
        var status: TextView = itemView.findViewById(R.id.comp_status)
        var title: TextView = itemView.findViewById(R.id.comp_title)
        var startDate: TextView = itemView.findViewById(R.id.comp_start_date)
        var endDate: TextView = itemView.findViewById(R.id.comp_end_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.competitions_item, parent, false)

        return CompetitionsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return compList.size
    }

    override fun onBindViewHolder(holder: CompetitionsViewHolder, position: Int) {
        holder.sport?.text = compList[position].sport
        holder.status?.text = compList[position].status
        holder.title?.text = compList[position].title
        holder.startDate?.text = compList[position].startDate
        holder.endDate?.text = compList[position].endDate
    }
}