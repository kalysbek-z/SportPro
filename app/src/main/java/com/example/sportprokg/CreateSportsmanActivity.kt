package com.example.sportprokg

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_create_sportsman.*
import kotlinx.android.synthetic.main.activity_sportsman.*
import kotlinx.android.synthetic.main.activity_sportsman.sportsman_toolbar
import kotlinx.android.synthetic.main.spinner_item2.*
import org.w3c.dom.Text
import java.util.jar.Manifest

class CreateSportsmanActivity : AppCompatActivity() {

    companion object {
        private val IMAGE_CHOOSE = 1000;
        private val PERMISSION_CODE = 1001;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_sportsman)

        setToolbar()
        setSpinners()

        create_sm_btn.setOnClickListener {

        }
    }

    private fun requestGalleryPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.CAMERA, Manife})
        }
    }

    private fun loadProfilePhoto() {

    }

    private fun setToolbar() {
        sportsman_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setSpinners() {
        val genders: Array<String> = resources.getStringArray(R.array.genders)
        val regions: Array<String> = resources.getStringArray(R.array.regions2)
        val category: Array<String> = resources.getStringArray(R.array.category_by_age)
        val typeOfSport: Array<String> = resources.getStringArray(R.array.categories)
        val sportName: Array<String> = resources.getStringArray(R.array.type_of_sport)

//        val genderAdapter: ArrayAdapter<String> =
//            object : ArrayAdapter<String>(this, R.layout.spinner_item2_gray, genders) {
//                override fun getDropDownView(
//                    position: Int,
//                    convertView: View?,
//                    parent: ViewGroup
//                ): View {
//                    val view: TextView =
//                        super.getDropDownView(
//                            position,
//                            convertView,
//                            parent
//                        ) as TextView
//
//                    if (position == create_sm_gender_spinner.selectedItemPosition && position != 0) {
//                        view.setTextColor(resources.getColor(R.color.white))
//                    }
//
//                    if (position == 0) {
//                        view.setTextColor(resources.getColor(R.color.gray))
//                    }
//
//                    return view
//                }
//
//                override fun isEnabled(position: Int): Boolean {
//                    return position != 0
//                }
//            }
        val genderAdapter = ArrayAdapter(this, R.layout.spinner_item2, genders)
        create_sm_gender_spinner.adapter = genderAdapter

        val regionAdapter = ArrayAdapter(this, R.layout.spinner_item2, regions)
        create_sm_region_spinner.adapter = regionAdapter

        val categoryAdapter = ArrayAdapter(this, R.layout.spinner_item2, category)
        create_sm_category_spinner.adapter = categoryAdapter

        val typeOfSportAdapter = ArrayAdapter(this, R.layout.spinner_item2, typeOfSport)
        create_sm_sporttype_spinner.adapter = typeOfSportAdapter

        val sportNameAdapter = ArrayAdapter(this, R.layout.spinner_item2, sportName)
        create_sm_sport_name_spinner.adapter = sportNameAdapter
    }
}