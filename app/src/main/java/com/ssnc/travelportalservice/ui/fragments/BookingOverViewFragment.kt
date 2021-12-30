package com.ssnc.travelportalservice.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ssnc.travelportalservice.R
import kotlinx.android.synthetic.main.layout_booking_bottom_confirm.*

class BookingOverViewFragment : Fragment(R.layout.layout_booking_overview), OnMapReadyCallback,
    View.OnClickListener {

    private val LAT = 28.3949
    private val LNG = 84.1240

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFrag: SupportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFrag.getMapAsync(this)

        lay_pay_now.setOnClickListener(this)
    }

    companion object {
        fun newInstance() = BookingOverViewFragment()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val point = LatLng(LAT, LNG)
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        googleMap.addMarker(MarkerOptions().position(point).title("Test Point"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(point))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(9F))
//        googleMap.moveCamera(point)
//        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15F))
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when (view.id) {
            R.id.map -> {
                val lat = "84.39130783081055"
                val lng = "27.917676746894607"
                // Create a Uri from an intent string. Use the result to create an Intent.
                val gmmIntentUri = Uri.parse("google.streetview:cbll=$lat,$lng")

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps")

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent)
            }
            R.id.lay_pay_now -> {
                if (findNavController().currentDestination?.id == R.id.booking_overview){
//                val action = BookingOverViewFragmentDirections.actionBookingOverViewFragmentToPaymentOptionFragment()
//                findNavController().navigate(action)
                    view.findNavController().navigate(R.id.action_bookingOverViewFragment_to_paymentOptionFragment)
                }
            }
        }
    }
}