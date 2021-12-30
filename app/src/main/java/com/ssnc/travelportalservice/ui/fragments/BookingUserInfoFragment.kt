package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ssnc.travelportalservice.R
import kotlinx.android.synthetic.main.layout_booking_user_info.*

class BookingUserInfoFragment : Fragment(R.layout.layout_booking_user_info), View.OnClickListener {

    companion object {
        fun newInstance() = BookingUserInfoFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_book_info_next.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when(view.id) {
            R.id.btn_book_info_next -> {
                Log.d("TAGCLICK", "destination: ${findNavController().currentDestination?.label}")
                if (findNavController().currentDestination?.id == R.id.book_user_info) {
                    view.findNavController().navigate(R.id.action_bookingUserInfoFragment_to_bookingOverViewFragment)
                }
            }
        }
    }
}