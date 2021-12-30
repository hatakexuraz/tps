package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.adapters.FragmentTabAdapter
import kotlinx.android.synthetic.main.fragment_book_hotel.*
import kotlinx.android.synthetic.main.layout_booking_bottom_confirm.*

class BookHotelFragment : Fragment(R.layout.fragment_book_hotel) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        tab_pager.adapter = FragmentTabAdapter(this)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.book_progress_container) as NavHostFragment
        val navController = navHostFragment.navController.setGraph(R.navigation.nav_book_graph)

//        lay_pay_now.setOnClickListener(this)

        if (findNavController().currentDestination?.id == R.id.book_user_info) {
            Log.d("NavDestination", "${findNavController().currentDestination?.id}")
            book_progress.progress = 50
        }
        if (findNavController().currentDestination?.id == R.id.booking_overview) {
            Log.d("NavDestination", "${findNavController().currentDestination?.id}")
            book_progress.progress = 100
        }
        if (findNavController().currentDestination?.id == R.id.payment_options) {
            Log.d("NavDestination", "${findNavController().currentDestination?.id}")
            book_progress.visibility = View.INVISIBLE
//            book_progress.progress = 0
        }
    }

//    override fun onClick(view: View?) {
//        if (view == null) return
//        when(view.id) {
//            R.id.lay_pay_now -> {
////                val action = BookingOverViewFragmentDirections.actionBookingOverViewFragmentToPaymentOptionFragment()
////                findNavController().navigate(action)
//                view.findNavController().navigate(R.id.action_bookingOverViewFragment_to_paymentOptionFragment)
//            }
//        }
//    }
}