package com.ssnc.travelportalservice.util

object Constant {

    const val BASE_URL = "http://192.168.1.199:8083/RestHotel/"

    //API
    const val HOTEL_NAME_SEARCH = "hotelDetail/search/{value}"
    const val HOTEL_ADDRESS_SEARCH = "address/search/{value}"
    const val HOTEL_FILTER = "search/hotelFilter"
    const val HOTEL_ADVANCE_FILTER = "search/advanceSearch"
    const val ROOM_FILTER = "search/roomFilter"

    //PAYMENT APIs
    const val HOTEL_BOOKING_WITH_PAY = "hotelBooking/requestConfirmWithPayAtHotel"
    const val NPAY_PAYMENT_REQUEST = "hotelBooking/npayValidateMerchant"
    const val NPAY_PAYMENT_CONFIRMATION = "hotelBooking/npayVerifyTransaction1?MERCHANTTXNID= &GTWREFNO="
    const val ESEWA_PAYMENT_REQUEST = "hotelBooking/esewaConfig"
    const val ESEWA_PAYMENT_CONFIRMATION = "hotelBooking/esewaConfirm"

    //BOOKING API
    const val HOTEL_BOOKING = "hotelBooking/request"
    const val BOOKING_DETAIL_WITH_INVOICE = "hotelBooking/invoiceNo"
    const val CANCEL_BOOKING_WITH_INVOICE = "hotelBooking/cancelBooking"
}