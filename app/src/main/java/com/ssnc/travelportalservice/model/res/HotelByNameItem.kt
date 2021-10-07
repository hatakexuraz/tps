package com.ssnc.travelportalservice.model.res

import java.io.Serializable

data class HotelByNameItem(
    val address: Address,
    val description: String,
    val hotelDetailId: String,
    val hotelName: String,
    val lat: String,
    val lng: String,
    val starRating: String
) : Serializable