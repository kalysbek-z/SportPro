package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportprokg.repository.CompetitionsRepository
import java.lang.IllegalArgumentException

class CompetitionsViewModelProviderFactory constructor(private val repository: CompetitionsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CompetitionsViewModel::class.java)) {
            CompetitionsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}