package com.example.sportprokg.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportprokg.R
import com.example.sportprokg.models.CompetitionsItem
import kotlinx.android.synthetic.main.competitions_item.view.*

class CompetitionsAdapter(
    private val listener: OnItemClickListener,
    val context: Context
) :
    RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder>() {

    var compList = mutableListOf<CompetitionsItem>()

    fun setData(data: MutableList<CompetitionsItem>) {
        this.compList = data
        notifyDataSetChanged()
    }

    fun getCompetition(position: Int): CompetitionsItem {
        return compList[position]
    }

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
        val currentItem = compList[position]

        holder.sport?.text = currentItem.sportType?.sport
        holder.status?.text = currentItem.status
        holder.title?.text = currentItem.title
        holder.startDate?.text = currentItem.startDate
        holder.endDate?.text = currentItem.finishDate

        Glide.with(context)
            .load(currentItem.image)
            .centerCrop()
            .into(holder.image)
    }

    inner class CompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val image: ImageView = itemView.comp_image
        var sport: TextView = itemView.comp_typeof_sport
        var status: TextView = itemView.comp_status
        var title: TextView = itemView.comp_title
        var startDate: TextView = itemView.comp_start_date
        var endDate: TextView = itemView.comp_end_date

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