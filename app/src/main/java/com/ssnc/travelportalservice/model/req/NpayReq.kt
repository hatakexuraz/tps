package com.ssnc.travelportalservice.model.req

data class NpayReq(
    val customerDetailId: String,
    val guestEmailId: String,
    val guestName: String,
    val guestPhNo: String,
    val hashCode: String
)