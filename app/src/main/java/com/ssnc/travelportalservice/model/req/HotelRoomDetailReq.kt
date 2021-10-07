package com.ssnc.travelportalservice.model.req

data class HotelRoomDetailReq(
    val checkInDate: String,
    val checkOutDate: String,
    val childAges: String,
    val currencyDesc: String,
    val hotelDetailId: String,
    val noOfAdult: String,
    val noOfChild: String,
    val noOfRooms: String
)