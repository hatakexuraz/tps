package com.ssnc.travelportalservice.model.req

data class AdvanceFilter(
    val activities: String,
    val amenities: String,
    val fromPrice: String,
    val offSet: String,
    val offer: String,
    val pageNo: String,
    val searchKey: String,
    val sortingType: String,
    val starRange: String,
    val toPrice: String
)