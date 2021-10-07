package com.ssnc.travelportalservice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ssnc.travelportalservice.repository.HotelRepository

class HotelViewModelProviderFactory(
    val repository: HotelRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HotelViewModel(repository) as T
    }
}