package com.example.sportprokg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportprokg.R
import com.example.sportprokg.models.ResultItem

class DetailedCompetitionsResultsAdapter(
    private val resultList: List<ResultItem>
) :
    RecyclerView.Adapter<DetailedCompetitionsResultsAdapter.ResultsViewHolder>() {

    inner class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var place: TextView = itemView.findViewById(R.id.result_place_tv)
        var name: TextView = itemView.findViewById(R.id.result_name_tv)
        var age: TextView = itemView.findViewById(R.id.result_name_tv)
        var weight: TextView = itemView.findViewById(R.id.result_name_tv)
        var city: TextView = itemView.findViewById(R.id.result_name_tv)
        var organization: TextView = itemView.findViewById(R.id.result_name_tv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.result_item, parent, false)

        return ResultsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(
        holder: ResultsViewHolder,
        position: Int
    ) {
        holder.place?.text = "#" + resultList[position].place.toString()
        holder.name?.text = resultList[position].name
        holder.age?.text = resultList[position].age.toString() + " лет"
        holder.weight?.text = resultList[position].weight.toString() + " кг"
        holder.city?.text = resultList[position].city + ","
        holder.organization?.text = resultList[position].organization
    }
}