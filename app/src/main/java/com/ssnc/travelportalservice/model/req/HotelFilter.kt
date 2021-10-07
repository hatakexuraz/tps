package com.ssnc.travelportalservice.model.req

data class HotelFilter(
    val checkInDate: String,
    val checkOutDate: String,
    val childAges: String,
    val currencyDesc: String,
    val noOfAdult: String,
    val noOfChild: String,
    val noOfRooms: String,
    val offSet: String,
    val pageNo: String,
    val searchValue: String,
    val type: String
)