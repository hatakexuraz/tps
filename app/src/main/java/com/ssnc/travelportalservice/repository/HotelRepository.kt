package com.ssnc.travelportalservice.repository

import com.ssnc.travelportalservice.api.RetrofitInstance
import com.ssnc.travelportalservice.model.req.*
import java.net.ConnectException
import java.net.SocketTimeoutException

class HotelRepository {

    suspend fun getHotelByName(hotelName: String) = try {
        RetrofitInstance.api.getHotelByName(hotelName)
    } catch (e : SocketTimeoutException) {
        null
    } catch (e : ConnectException) {
        null
    }

    suspend fun getHotelByAddress(address: String) =
        RetrofitInstance.api.getHotelByAddress(address)

    suspend fun getHotelByFilter(hotelFilter: HotelFilter) =
        RetrofitInstance.api.getHotelByFilter(hotelFilter)

    suspend fun getHotelByAdvanceFilter(advanceFilter: AdvanceFilter) =
        RetrofitInstance.api.getHotelByAdvanceFilter(advanceFilter)

    suspend fun getRoomByFilter(hotelRoomDetailReq: HotelRoomDetailReq) =
        RetrofitInstance.api.getRoomByFilter(hotelRoomDetailReq)

    suspend fun hotelBooking(roomBooking: HotelRoomBooking) =
        RetrofitInstance.api.hotelBooking(roomBooking)

    suspend fun hotelBookingWithPay(bookingRoomWithPay: BookingRoomWithPay) =
        RetrofitInstance.api.hotelBookingWithPay(bookingRoomWithPay)

    suspend fun nPayRequest(pay : NpayReq) =
        RetrofitInstance.api.nPayRequest(pay)

    suspend fun nPayConfirmation() =
        RetrofitInstance.api.nPayConfirmation()

    suspend fun eSewaPaymentRequest(esewaPaymentReq: EsewaPaymentReq) =
        RetrofitInstance.api.eSewaPaymentRequest(esewaPaymentReq)

    suspend fun eSewaPaymentConfirmation(esewaPaymentConfirm: EsewaPaymentConfirm) =
        RetrofitInstance.api.eSewaPaymentConfirmation(esewaPaymentConfirm)

    suspend fun bookingDetailByInvoice(invoice: Invoice) =
        RetrofitInstance.api.bookingDetailByInvoice(invoice)

    suspend fun cancelBookingByInvoice(invoice: Invoice) =
        RetrofitInstance.api.cancelBookingByInvoice(invoice)
}