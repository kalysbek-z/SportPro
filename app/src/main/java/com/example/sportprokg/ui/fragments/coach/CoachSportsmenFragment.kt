package com.example.sportprokg.ui.fragments.coach

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportprokg.CreateSportsmanActivity
import com.example.sportprokg.R
import com.example.sportprokg.SportsmanActivity
import com.example.sportprokg.adapters.SportsmenAdapter
import com.example.sportprokg.models.SportsmanItem
import kotlinx.android.synthetic.main.fragment_coach_sportsmen.view.*

class CoachSportsmenFragment : Fragment(), SportsmenAdapter.OnItemClickListener {

    val list = mutableListOf<SportsmanItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coach_sportsmen, container, false)

        view.coach_sportsman_recycler.layoutManager = LinearLayoutManager(requireContext())
        view.coach_sportsman_recycler.adapter =
            SportsmenAdapter(dummyData(), this@CoachSportsmenFragment)
        view.coach_sportsman_recycler.setHasFixedSize(true)

        addSportsman(view)

        return view
    }

    private fun addSportsman(view: View) {
        view.coach_add_btn.setOnClickListener {
            val intent = Intent(requireContext(), CreateSportsmanActivity::class.java)
            startActivity(intent)
        }
    }

    private fun dummyData(): List<SportsmanItem> {

        list.add(
            SportsmanItem(
                "name",
                "name",
                "name",
                "01.01.2000",
                1,
                5,
                "+996 550 50 50 50",
                1,
                1,
                1,
                30,
                60,
                "Бишкек",
                "WorldClass"
            )
        )

        return list
    }

    override fun onItemClick(position: Int) {
        val firstName = list[position].firstName
        val surname = list[position].surname
        val midName = list[position].midName
        val birthday = list[position].birthday
        val gender = list[position].gender
        val region = list[position].region
        val phone = list[position].phoneNumber
        val weight = list[position].weight
        val category = list[position].category
        val sportType = list[position].typeOfSport
        val sportName = list[position].sportName
        val organization = list[position].organization

        val intent = Intent(requireContext(), SportsmanActivity::class.java)
        intent.putExtra("firstname", firstName)
        intent.putExtra("surname", surname)
        intent.putExtra("midName", midName)
        intent.putExtra("birthday", birthday)
        intent.putExtra("gender", gender)
        intent.putExtra("region", region)
        intent.putExtra("phone", phone)
        intent.putExtra("weight", weight)
        intent.putExtra("category", category)
        intent.putExtra("type", sportType)
        intent.putExtra("sportName", sportName)
        intent.putExtra("org", organization)

        startActivity(intent)
    }
}