package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ssnc.travelportalservice.R
import kotlinx.android.synthetic.main.layout_hotel_view_pager.*

class ImageSlidePageFragment(val fragment: Fragment) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_hotel_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey("position") && it.containsKey("total") && it.containsKey("image") }?.apply {
            Glide.with(fragment).load(getInt("image")).into(hotel_image)

            val position = "${getInt("position")}/${getInt("total")}"
            image_position.text =position
        }
    }
}