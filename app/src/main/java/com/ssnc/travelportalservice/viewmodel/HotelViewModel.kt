package com.ssnc.travelportalservice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssnc.travelportalservice.model.res.HotelByName
import com.ssnc.travelportalservice.repository.HotelRepository
import com.ssnc.travelportalservice.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException

class HotelViewModel(
    private val repository: HotelRepository
) : ViewModel() {

    val hotelByName: MutableLiveData<Resource<HotelByName>> = MutableLiveData()

    init {
        getHotelByName("Hotel")
    }

    private fun getHotelByName(hotelName : String) = viewModelScope.launch {
        hotelByName.postValue(Resource.Loading())

        val response = repository.getHotelByName(hotelName)
        hotelByName.postValue(handleGetHotelByName(response))
    }

    private fun handleGetHotelByName(response: Response<HotelByName>?): Resource<HotelByName> {
        if (response != null) {
            if (response.isSuccessful) {
                response.body()?.let {
                    return Resource.Success(it)
                }
            }
        }
        return Resource.Error("Something went wrong")
    }

    fun getHotel(hotel:String) {
        getHotelByName(hotel)
    }
}