package com.ssnc.travelportalservice.model.req

data class EsewaPaymentConfirm(
    val customerDetailId: String,
    val guestEmailId: String,
    val guestName: String,
    val guestPhNo: String,
    val hashCode: String
)