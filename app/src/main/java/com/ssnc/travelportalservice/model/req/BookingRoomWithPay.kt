package com.ssnc.travelportalservice.model.req

data class BookingRoomWithPay(
    val airportShuttle: String,
    val arrivalDateTime: String,
    val country: String,
    val guestEmailId: String,
    val guestName: String,
    val guestPhNo: String,
    val hashCode: String,
    val identificationNo: String,
    val specialRequest: String
)