package com.example.sportprokg.ui.fragments.registration

import android.app.role.RoleManager
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.fragment_role.view.*

var role = 0

class RoleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_role, container, false)

        view.coach_btn.setOnClickListener {
            role = 1
            Navigation.findNavController(view)
                .navigate(R.id.action_roleFragment_to_phoneNumberFragment)
        }

        view.judge_btn.setOnClickListener {
            role = 2
            Navigation.findNavController(view)
                .navigate(R.id.action_roleFragment_to_phoneNumberFragment)
        }

        return view
    }

}