package com.example.sportprokg.ui.fragments.registration

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sportprokg.R
import com.example.sportprokg.ui.fragments.referee.RefereeFragment


class RequestSentFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_request_sent, container, false)

        val handler = Handler()
        handler.postDelayed({
//            Navigation.findNavController(view)
//                .navigate(R.id.action_requestSentFragment_to_refreeFragment)

            val refereeFragment = RefereeFragment()
            val transaction = fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment, refereeFragment)
                ?.commit()
        }, 1500)

        return view
    }


}