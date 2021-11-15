package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.MainActivity
import com.ssnc.travelportalservice.ui.adapters.ImageSlidePagerAdapter
import com.ssnc.travelportalservice.viewmodel.HotelViewModel
import kotlinx.android.synthetic.main.layout_hotel_book_bottom_view.*
import kotlinx.android.synthetic.main.layout_hotel_det.*

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.ssnc.travelportalservice.ui.adapters.ImageSliderAdapter
import kotlinx.android.synthetic.main.bottom_sheet_bed_room_picker.*
import kotlinx.android.synthetic.main.fragment_hotel_detail.*

class HotelDetailFragment : Fragment(R.layout.fragment_hotel_detail), View.OnClickListener,
    NumberPicker.OnValueChangeListener {
    lateinit var viewModel: HotelViewModel
    val args: HotelDetailFragmentArgs by navArgs()
    private var bottomSheetBehavior: BottomSheetBehavior<*>? = null


    val bedSize = arrayOf("King Size", "Queen Size", "Full Size", "Twin Bed", "Single Bed")
    val roomType =
        arrayOf("King Room", "Queen Room", "Deluxe Room", "Twin Room", "Presidential Room")
    var identifier = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).hotelViewModel

//        val imageAdapter = ImageSlidePagerAdapter(this)
        image_slider.setSliderAdapter(ImageSliderAdapter(requireContext()))
        image_slider.startAutoCycle()

        val hotel = args.hotel

        hotel_name.text = hotel.hotelName
        hotel_location.text = hotel.address.addressNameEdited
        txt_rate.text = hotel.starRating
        hotel_description.text = hotel.description
        bg.setOnClickListener(this)
        book_now_layout.setOnClickListener(this)

        bed_size_layout.setOnClickListener(this)
        room_type_layout.setOnClickListener(this)

        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        (bottomSheetBehavior as BottomSheetBehavior<*>).peekHeight = book_bottom_view.height
        (bottomSheetBehavior as BottomSheetBehavior<*>).addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bg.visibility = View.VISIBLE
                }
                if (newState == BottomSheetBehavior.STATE_DRAGGING || newState == BottomSheetBehavior.STATE_SETTLING) {
                    bg.visibility = View.VISIBLE
                }
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    bg.visibility = View.INVISIBLE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                bg.visibility = View.INVISIBLE
//                bg.alpha = slideOffset
            }
        })

        picker_bed_room.setOnValueChangedListener(this)
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when (view.id) {
            R.id.bed_size_layout -> {
                identifier = "Bed"
                setPickerData()
                bg.visibility = View.VISIBLE
//                bottomSheetBehavior!!.state = BottomSheetBehavior.STATE_DRAGGING
                bottomSheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
            }
            R.id.room_type_layout -> {
                identifier = "Room"
                setPickerData()
                bg.visibility = View.VISIBLE
//                bottomSheetBehavior!!.state = BottomSheetBehavior.STATE_DRAGGING
                bottomSheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED

            }
            R.id.book_now_layout -> {
                val action =
                    HotelDetailFragmentDirections.actionHotelDetailFragmentToBookHotelFragment()
                findNavController().navigate(action)
            }
            R.id.bg -> {
                bg.visibility = View.INVISIBLE
                bottomSheetBehavior!!.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }

    private fun setPickerData() {
        if (identifier == "Bed") {
            picker_bed_room.let {
                it.minValue = 0
                it.maxValue = bedSize.size - 1
                it.displayedValues = bedSize
            }
        }
        if (identifier == "Room") {
            picker_bed_room.let {
                it.minValue = 0
                it.maxValue = roomType.size - 1
                it.displayedValues = roomType
            }
        }
    }

    override fun onValueChange(numberPicker: NumberPicker?, oldValue: Int, newValue: Int) {
        if (identifier == "Bed") {
            txt_bed_size.text = bedSize[newValue]
        }
        if (identifier == "Room") {
            txt_room_type.text = roomType[newValue]
        }
    }
}