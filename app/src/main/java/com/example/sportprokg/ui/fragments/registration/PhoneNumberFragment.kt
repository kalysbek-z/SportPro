package com.example.sportprokg.ui.fragments.registration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.sportprokg.R
import com.example.sportprokg.ui.Activities.MainActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_confirmation.view.*
import kotlinx.android.synthetic.main.fragment_phone_number.view.*
import java.util.concurrent.TimeUnit

class PhoneNumberFragment : Fragment() {

//    private var verificationID: String? = null

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

            val bundle = Bundle()
            var phoneNumber = view.phone_number_edit_text.text.toString().trim()
            bundle.putString("phone", phoneNumber)
            val confirmationFragment = ConfirmationFragment()
            confirmationFragment.arguments = bundle
            val transaction = fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment, confirmationFragment)
                ?.commit()
//            var intent = activity?.intent
//            intent?.putExtra("phone", phoneNumber)

//            Navigation.findNavController(view)
//                .navigate(R.id.action_phoneNumberFragment_to_confirmationFragment)
        }

        view.phone_number_toolbar.setNavigationIcon(R.drawable.ic_back)
        view.phone_number_toolbar.setNavigationOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_phoneNumberFragment_to_roleFragment)
        }

//        view.sign_in_btn.setOnClickListener {
//
//            var phoneNumber = view.phone_number_edit_text.text.toString().trim()
//
//            if (!phoneNumber.isEmpty() || phoneNumber.length == 13) {
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                    view.phone_number_edit_text.getParsedText().toString(),
//                    60,
//                    TimeUnit.SECONDS,
//                    requireActivity(),
//                    phoneAuthCallbacks
//                )
//            }
//        }

        return view
    }

//    val phoneAuthCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
//
//        }
//
//        override fun onVerificationFailed(p0: FirebaseException) {
//
//        }
//
//        override fun onCodeSent(
//            verificationID: String,
//            token: PhoneAuthProvider.ForceResendingToken
//        ) {
//            super.onCodeSent(verificationID, token)
//
//            this@PhoneNumberFragment.verificationID = verificationID
//        }
//    }

}