package com.ssnc.travelportalservice.model.req

data class EsewaPaymentReq(
    val customerDetailId: String,
    val guestEmailId: String,
    val guestName: String,
    val guestPhNo: String,
    val hashCode: String
)