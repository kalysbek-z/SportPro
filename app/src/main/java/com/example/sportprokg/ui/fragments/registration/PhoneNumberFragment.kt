package com.example.sportprokg.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.fragment_confirmation.view.*
import kotlinx.android.synthetic.main.fragment_phone_number.view.*

class PhoneNumberFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_phone_number, container, false)

        view.sign_in_btn.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_phoneNumberFragment_to_confirmationFragment)
        }

        return view
    }

}