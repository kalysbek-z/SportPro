package com.example.sportprokg.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.fragment_confirmation.view.*
import kotlinx.android.synthetic.main.fragment_registration.view.*

class ConfirmationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)

        view.confirm_button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_confirmationFragment_to_registrationFragment)
        }

        view.confirm_toolbar.setNavigationIcon(R.drawable.ic_back)
        view.confirm_toolbar.setNavigationOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_confirmationFragment_to_phoneNumberFragment)
        }
        return view
    }

}