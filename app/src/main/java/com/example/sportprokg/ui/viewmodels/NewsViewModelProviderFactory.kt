package com.example.sportprokg.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportprokg.repository.NewsRepository
import java.lang.IllegalArgumentException

class NewsViewModelProviderFactory constructor(private val repository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            NewsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}