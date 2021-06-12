package com.example.sportprokg.ui.fragments.registration

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toolbar
import androidx.navigation.Navigation
import com.example.sportprokg.R
import com.example.sportprokg.R.*
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.android.synthetic.main.fragment_registration.view.*


class RegistrationFragment : Fragment() {

    private var documents: ArrayList<Uri?>? = null
    private var isDocumentsAttached = false

    //position of current selected image
    private val currentPosition = 0
    private val PICK_IMAGES_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onPause() {
        super.onPause()

//        resizeByContainer()
    }

    override fun onResume() {
        super.onResume()
//        resizeByContainer()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(layout.fragment_registration, container, false)

        setUpSpinners(view)

        documents = ArrayList()

        view.attach_button.setOnClickListener {
            pickImagesIntent()
        }

        view.delete1.setOnClickListener {
            if (documents!!.size > 1) {
                if (documents!!.size > 1 && documents!![1] != null) {
                    file1.setImageURI(documents!![1])
                    file2.setImageURI(null)
                    view.cv2.visibility = View.GONE
                    documents!!.removeAt(0)
                } else {
                    file1.setImageURI(null)
                }
                if (documents!!.isEmpty()) {
                    view.files_container.visibility = View.GONE
                }
            } else {
//                Toast.makeText(context, "DA", Toast.LENGTH_SHORT)
                file1.setImageURI(null)
                if (documents!!.size == 1) {
                    documents!!.removeAt(0)
                }
                view.files_container.visibility = View.GONE
            }
        }

        view.delete2.setOnClickListener {
            if (documents!!.size > 1) {
                documents!!.removeAt(1)
                file2.setImageURI(null)
                view.cv2.visibility = View.GONE
            }
        }

        view.register_btn.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_registrationFragment_to_requestSentFragment)
        }

        view.reg_toolbar.setNavigationIcon(R.drawable.ic_back)
        view.reg_toolbar.setNavigationOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_registrationFragment_to_confirmationFragment)
        }

        return view
    }

    private fun pickImagesIntent() {
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(
                intent,
                "Прикрепите документ подтверждающий вашу квалификацию тренера"
            ), PICK_IMAGES_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGES_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                if (data!!.clipData != null) {
                    //if multiple documents attached
                    //get total number of docs
                    val count = data.clipData!!.itemCount
                    for (i in 0 until count) {
                        val imgUri = data.clipData!!.getItemAt(i).uri
                        //add img in array list
                        documents!!.add(imgUri)
                    }
                    file1.setImageURI(documents!![0])
                    file2.setImageURI(documents!![1])
                    cv1.visibility = View.VISIBLE
                    cv2.visibility = View.VISIBLE
                } else {
                    //if single document
                    val imgUri = data.data
                    file1.setImageURI(imgUri)
                    cv1.visibility = View.VISIBLE
                }
                files_container.visibility = View.VISIBLE
                isDocumentsAttached = true
            }
        }
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