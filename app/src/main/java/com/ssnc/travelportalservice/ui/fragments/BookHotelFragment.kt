package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.adapters.FragmentTabAdapter
import kotlinx.android.synthetic.main.fragment_book_hotel.*
import kotlinx.android.synthetic.main.layout_booking_bottom_confirm.*

class BookHotelFragment : Fragment(R.layout.fragment_book_hotel), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tab_pager.adapter = FragmentTabAdapter(this)

//        lay_pay_now.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when(view.id) {
            R.id.lay_pay_now -> {
//                val action = BookingOverViewFragmentDirections.actionBookingOverViewFragmentToPaymentOptionFragment()
//                findNavController().navigate(action)
                view.findNavController().navigate(R.id.action_bookingOverViewFragment_to_paymentOptionFragment)
            }
        }
    }
}