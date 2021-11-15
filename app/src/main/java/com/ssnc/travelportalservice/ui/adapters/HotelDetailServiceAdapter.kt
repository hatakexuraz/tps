package com.ssnc.travelportalservice.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssnc.travelportalservice.R
import kotlinx.android.synthetic.main.layout_hotel_service_det.view.*
import kotlin.coroutines.coroutineContext

class HotelDetailServiceAdapter() : RecyclerView.Adapter<HotelDetailServiceAdapter.ServiceViewHolder>() {

    private val service = arrayListOf("wifi", "ac", "tv", "breakfast", "Swimming")
    val icon = arrayListOf(R.drawable.ic_ac, R.drawable.ic_wifi, R.drawable.ic_pool, R.drawable.ic_breakfast, R.drawable.ic_tv)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_hotel_service_det, parent, false))
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
//        holder.itemView.service_icon.setImageDrawable()
    }

    override fun getItemCount(): Int {
        return service.size-1
    }

    class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}