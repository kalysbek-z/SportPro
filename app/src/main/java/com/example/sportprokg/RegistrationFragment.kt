package com.example.sportprokg

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Spinner
import com.example.sportprokg.R.*
import kotlinx.android.synthetic.main.fragment_registration.view.*


class RegistrationFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(layout.fragment_registration, container, false)

        setUpSpinners(view)

        if (view.files_container.visibility == View.VISIBLE) {
            val height = 996
            val containerParams = view.container.layoutParams
            containerParams.height += 80
            view.container.layoutParams = containerParams
            view.container.requestLayout()

            val frameParams = view.frame.layoutParams
            frameParams.height += 80
            view.frame.layoutParams
            view.frame.requestLayout()
        }

        return view
    }

    private fun setUpSpinners(view: View) {
        //array adapters for spinners
        // regions (oblast')
        val regions = resources.getStringArray(array.regions)
        val regionsAdapter =
            ArrayAdapter(this!!.requireContext(), layout.spinner_item, regions)
        view.region_sp.adapter = regionsAdapter
        // categories of sports
        val categories = resources.getStringArray(array.categories)
        val categoriesAdapter =
            ArrayAdapter(this!!.requireContext(), layout.spinner_item, categories)
        view.category_sp.adapter = categoriesAdapter
        // type of sport
        val typesOfSport = resources.getStringArray(array.type_of_sport)
        val typesOfSportAdapter =
            ArrayAdapter(this!!.requireContext(), layout.spinner_item, typesOfSport)
        view.type_of_sport_sp.adapter = typesOfSportAdapter
    }
}