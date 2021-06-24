package com.example.sportprokg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.TeamItem

class DetailedCompetitionsTeamsAdapter(
    private val teamsList: List<TeamItem>
) :
    RecyclerView.Adapter<DetailedCompetitionsTeamsAdapter.TeamsViewHolder>() {

    inner class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var number: TextView = itemView.findViewById(R.id.team_number_tv)
        var city: TextView = itemView.findViewById(R.id.team_city_tv)
        var organization: TextView = itemView.findViewById(R.id.team_organization_tv)
        var participants: TextView = itemView.findViewById(R.id.team_part_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_item, parent, false)

        return TeamsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return teamsList.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.number?.text = teamsList[position].number.toString()
        holder.city?.text = teamsList[position].city
        holder.organization?.text = teamsList[position].organisation
        holder.participants?.text = teamsList[position].participant
    }
}