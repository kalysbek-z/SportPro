package com.example.sportprokg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.SportsmanItem
import com.example.sportprokg.ui.fragments.coach.CoachSportsmenFragment

class SportsmenAdapter(
    private val sportsmansList: List<SportsmanItem>,
    val listener: CoachSportsmenFragment
) :
    RecyclerView.Adapter<SportsmenAdapter.SportsmansViewHolder>() {

    inner class SportsmansViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var name: TextView = itemView.findViewById(R.id.sportsman_item_name_tv)
        var age: TextView = itemView.findViewById(R.id.sportsman_item_age_tv)
        var weight: TextView = itemView.findViewById(R.id.sportsman_item_weight_tv)
        var city: TextView = itemView.findViewById(R.id.sportsman_item_city_tv)
        var organization: TextView = itemView.findViewById(R.id.sportsman_item_organisation)

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SportsmenAdapter.SportsmansViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sportsman_item, parent, false)

        return SportsmansViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return sportsmansList.size
    }

    override fun onBindViewHolder(holder: SportsmansViewHolder, position: Int) {
        holder.name.text =
            sportsmansList[position].surname + " " + sportsmansList[position].firstName + " " + sportsmansList[position].midName
        holder.age.text = sportsmansList[position].age.toString() + " лет"
        holder.weight.text = sportsmansList[position].weight.toString() + " кг"
        holder.city.text = sportsmansList[position].city + ","
        holder.organization.text = sportsmansList[position].organization
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}