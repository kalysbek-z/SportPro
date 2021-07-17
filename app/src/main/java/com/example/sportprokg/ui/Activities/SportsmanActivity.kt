package com.example.sportprokg.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.sportprokg.R
import kotlinx.android.synthetic.main.activity_sportsman.*

class SportsmanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sportsman)
        setSpinners()
        setToolbar()
        setSportsmanData()
    }

    private fun setSportsmanData() {
        val mSurname = intent.getStringExtra("surname")
        val mFirstName = intent.getStringExtra("firstname")
        val mMidName = intent.getStringExtra("midName")
        val mBirthday = intent.getStringExtra("birthday")
        val mGender = intent.getIntExtra("gender", -1)
        val mRegion = intent.getIntExtra("region", -1)
        val mPhone = intent.getStringExtra("phone")
        val mWeight = intent.getIntExtra("weight", -1)
        val mCategory = intent.getIntExtra("category", -1)
        val mTypeOfSport = intent.getIntExtra("type", -1)
        val mSport = intent.getIntExtra("sportName", -1)
        val mOrganization = intent.getStringExtra("org")

        sportsman_surname.setText(mSurname)
        sportsman_name.setText(mFirstName)
        sportsman_midname.setText(mMidName)
        sportsman_birthday.setText(mBirthday)
        gender_spinner.setSelection(mGender)
        region_spinner.setSelection(mRegion)
        sportsman_phone.setText(mPhone)
        weight_et.setText(mWeight.toString())
        category_spinner.setSelection(mCategory)
        sporttype_spinner.setSelection(mTypeOfSport)
        sport_name_spinner.setSelection(mSport)
        sportsman_organisation_et.setText(mOrganization)
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

        val genderAdapter = ArrayAdapter(this,
            R.layout.spinner_item2, genders)
        gender_spinner.adapter = genderAdapter

        val regionAdapter = ArrayAdapter(this,
            R.layout.spinner_item2, regions)
        region_spinner.adapter = regionAdapter

        val categoryAdapter = ArrayAdapter(this,
            R.layout.spinner_item2, category)
        category_spinner.adapter = categoryAdapter

        val typeOfSportAdapter = ArrayAdapter(this,
            R.layout.spinner_item2, typeOfSport)
        sporttype_spinner.adapter = typeOfSportAdapter

        val sportNameAdapter = ArrayAdapter(this,
            R.layout.spinner_item2, sportName)
        sport_name_spinner.adapter = sportNameAdapter
    }
}