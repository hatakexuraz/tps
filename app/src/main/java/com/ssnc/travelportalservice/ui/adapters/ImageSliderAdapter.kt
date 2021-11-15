package com.ssnc.travelportalservice.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.ssnc.travelportalservice.R

class ImageSliderAdapter(val context: Context) : SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {

    val images = arrayListOf(R.drawable.background, R.drawable.manaslu, R.drawable.mandala, R.drawable.mustang, R.drawable.pagoda, R.drawable.pokhara, R.drawable.rara)

    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        return SliderAdapterVH(LayoutInflater.from(parent?.context).inflate(R.layout.layout_hotel_view_pager, null))
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
        if (viewHolder != null) {
            Glide.with(viewHolder.itemView)
                .load(images[position])
                .into(viewHolder.hotelImage)

            viewHolder.hotelImage.setOnClickListener {
                Toast.makeText(context, "Clicked on picture", Toast.LENGTH_SHORT).show()
            }
        }

    }

    class SliderAdapterVH(view : View) : SliderViewAdapter.ViewHolder(view) {
        var hotelImage : ImageView = view.findViewById(R.id.hotel_image)
    }
}

