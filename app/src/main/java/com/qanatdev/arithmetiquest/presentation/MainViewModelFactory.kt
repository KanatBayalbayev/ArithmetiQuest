package com.qanatdev.arithmetiquest.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qanatdev.arithmetiquest.domain.entities.Level


class MainViewModelFactory(
    private val level: Level,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, level) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}