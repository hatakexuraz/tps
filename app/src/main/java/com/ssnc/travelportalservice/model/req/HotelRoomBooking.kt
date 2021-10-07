package com.ssnc.travelportalservice.model.req

data class HotelRoomBooking(
    val RoomDetailId: String,
    val checkInDate: String,
    val checkOutDate: String,
    val currencyDesc: String,
    val medium: String,
    val noOfAdult: String,
    val noOfChild: String,
    val noOfRooms: String
)