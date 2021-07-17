package com.example.sportprokg.ui.fragments.registration

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sportprokg.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_confirmation.view.*
import java.util.concurrent.TimeUnit

class ConfirmationFragment : Fragment() {

    private lateinit var phoneNumber: String

    private var forceResendingToken: PhoneAuthProvider.ForceResendingToken? = null
    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    private lateinit var mVerificationId: String
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)

        val bundle = arguments
        if (bundle != null) {
            phoneNumber = bundle.getString("phone").toString()
            view.enter_as_tv.text = "На  номер $phoneNumber\n отправлен код подтверждения"
        }

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(requireContext())
        progressDialog.setTitle("Подождите")
        progressDialog.setCanceledOnTouchOutside(false)

        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                progressDialog.dismiss()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                super.onCodeSent(verificationId, token)

                mVerificationId = verificationId
                forceResendingToken = token
                progressDialog.dismiss()
            }
        }

        startPhoneNumberVerification(phoneNumber)

        view.confirm_button.setOnClickListener {

            val code = view.confirm_code_edit_text.getParsedText().toString().trim()
            if (!code.isEmpty()) {
                verifyByCode(mVerificationId, code)
            }

//            Navigation.findNavController(view)
//                .navigate(R.id.action_confirmationFragment_to_registrationFragment)
        }

        view.send_again_button.setOnClickListener {
            resendVerificationCode(phoneNumber, forceResendingToken)
        }

        view.confirm_toolbar.setNavigationIcon(R.drawable.ic_back)
        view.confirm_toolbar.setNavigationOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_confirmationFragment_to_phoneNumberFragment)
        }
        return view
    }

    private fun startPhoneNumberVerification(phone: String) {
        progressDialog.setMessage("Подтверждение кода...")
        progressDialog.show()

        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(mCallbacks!!)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun resendVerificationCode(
        phone: String,
        token: PhoneAuthProvider.ForceResendingToken?
    ) {
        progressDialog.setMessage("Повторная отправка кода подтверждения...")
        progressDialog.show()

        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(mCallbacks!!)
            .setForceResendingToken(token!!)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyByCode(verificationId: String, code: String) {
        progressDialog.setMessage("Проверка кода...")
        progressDialog.show()

        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener {
//                val phone = firebaseAuth.currentUser?.phoneNumber
//
//                Navigation.findNavController(requireView())
//                    .navigate(R.id.action_confirmationFragment_to_registrationFragment)
                if (it.isSuccessful) {
                    val requestSentFragment = RequestSentFragment()
                    val transaction = fragmentManager?.beginTransaction()
                        ?.replace(R.id.fragment, requestSentFragment)
                        ?.commit()

                    progressDialog.dismiss()
                } else {
                    progressDialog.dismiss()
                }
            }
    }


}