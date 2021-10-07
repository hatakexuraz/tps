package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.MainActivity
import com.ssnc.travelportalservice.ui.adapters.ImageSlidePagerAdapter
import com.ssnc.travelportalservice.viewmodel.HotelViewModel
import kotlinx.android.synthetic.main.layout_hotel_det.*

class HotelDetailFragment : Fragment(R.layout.fragment_hotel_detail) {
    lateinit var viewModel: HotelViewModel
    val args : HotelDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).hotelViewModel

        val imageAdapter = ImageSlidePagerAdapter(this)
        image_pager.adapter = imageAdapter

        val hotel = args.hotel

        hotel_name.text = hotel.hotelName
        hotel_location.text = hotel.address.addressNameEdited
        txt_rate.text = hotel.starRating
        hotel_description.text = hotel.description
    }
}