package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportprokg.repository.FilterRepository
import java.lang.IllegalArgumentException

class FilterViewModelProviderFactory constructor(private val repository: FilterRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
            FilterViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}