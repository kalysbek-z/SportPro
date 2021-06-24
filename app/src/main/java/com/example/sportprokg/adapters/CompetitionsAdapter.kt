package com.example.sportprokg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.CompetitionsItem
import com.example.sportprokg.ui.fragments.competitions.CompetitionsFragment

class CompetitionsAdapter(
    private val compList: List<CompetitionsItem>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompetitionsAdapter.CompetitionsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.competitions_item, parent, false)

        return CompetitionsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return compList.size
    }

    override fun onBindViewHolder(
        holder: CompetitionsAdapter.CompetitionsViewHolder,
        position: Int
    ) {
        holder.sport?.text = compList[position].sport
        holder.status?.text = compList[position].status
        holder.title?.text = compList[position].title
        holder.startDate?.text = compList[position].startDate
        holder.endDate?.text = compList[position].endDate
    }

    inner class CompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var sport: TextView = itemView.findViewById(R.id.comp_typeof_sport)
        var status: TextView = itemView.findViewById(R.id.comp_status)
        var title: TextView = itemView.findViewById(R.id.comp_title)
        var startDate: TextView = itemView.findViewById(R.id.comp_start_date)
        var endDate: TextView = itemView.findViewById(R.id.comp_end_date)

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