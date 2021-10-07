package com.ssnc.travelportalservice.api

import com.ssnc.travelportalservice.model.req.*
import com.ssnc.travelportalservice.model.res.HotelByName
import com.ssnc.travelportalservice.model.res.HotelByNameItem
import com.ssnc.travelportalservice.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HotelApi {

    @GET(Constant.HOTEL_NAME_SEARCH)
    suspend fun getHotelByName(@Path("value") hotelName : String) : Response<HotelByName>

    @GET(Constant.HOTEL_ADDRESS_SEARCH)
    suspend fun getHotelByAddress(@Path("value") address : String) : Response<HotelByName>      //temp - don't know the response body

    @POST(Constant.HOTEL_FILTER)
    suspend fun getHotelByFilter(hotelFilter: HotelFilter)              //temp -- don't know the response body

    @POST(Constant.HOTEL_ADVANCE_FILTER)
    suspend fun getHotelByAdvanceFilter(advanceFilter: AdvanceFilter)   //temp -- don't know the response body

    @POST(Constant.ROOM_FILTER)
    suspend fun getRoomByFilter(req : HotelRoomDetailReq)               //temp -- don't know the response body

    @POST(Constant.HOTEL_BOOKING)
    suspend fun hotelBooking(req : HotelRoomBooking)                    //temp -- don't know the response body

    @POST(Constant.HOTEL_BOOKING_WITH_PAY)
    suspend fun hotelBookingWithPay(req : BookingRoomWithPay)           //temp -- don't know the response body

    @POST(Constant.NPAY_PAYMENT_REQUEST)
    suspend fun nPayRequest(req : NpayReq)                              //temp -- don't know the response body

    @GET(Constant.NPAY_PAYMENT_CONFIRMATION)
    suspend fun nPayConfirmation()                                      //temp -- don't know the response body and API in general

    @POST(Constant.ESEWA_PAYMENT_REQUEST)
    suspend fun eSewaPaymentRequest(req : EsewaPaymentReq)              //temp -- don't know the response body

    @POST(Constant.ESEWA_PAYMENT_CONFIRMATION)
    suspend fun eSewaPaymentConfirmation(req : EsewaPaymentConfirm)     //temp -- don't know the response body

    @POST(Constant.BOOKING_DETAIL_WITH_INVOICE)
    suspend fun bookingDetailByInvoice(req : Invoice)                   //temp -- don't know the response body

    @POST(Constant.CANCEL_BOOKING_WITH_INVOICE)
    suspend fun cancelBookingByInvoice(req : Invoice)                   //temp -- don't know the response body
}