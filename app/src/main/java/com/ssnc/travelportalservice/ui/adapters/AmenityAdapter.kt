package com.ssnc.travelportalservice.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssnc.travelportalservice.R
import kotlinx.android.synthetic.main.layout_amenity.view.*

class AmenityAdapter(private val amenity : List<String>) : RecyclerView.Adapter<AmenityAdapter.AmenityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmenityViewHolder {
        return AmenityViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_amenity, parent, false))
    }

    override fun onBindViewHolder(holder: AmenityViewHolder, position: Int) {
       holder.itemView.apply {
           img_amenity_icon.setImageResource(R.drawable.ic_ac)
       }
    }

    override fun getItemCount(): Int {
        return amenity.size
    }

    inner class AmenityViewHolder(view: View) : RecyclerView.ViewHolder(view)
}