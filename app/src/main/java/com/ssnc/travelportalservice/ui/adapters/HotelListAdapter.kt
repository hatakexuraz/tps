package com.ssnc.travelportalservice.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.model.res.HotelByNameItem
import kotlinx.android.synthetic.main.layout_hotel_list.view.*

class HotelListAdapter() :
    RecyclerView.Adapter<HotelListAdapter.HotelViewHolder>() {

    inner class HotelViewHolder(view: View) : RecyclerView.ViewHolder(view)

    //calculates the difference between two lists and let us update those differences
    private val differCallback = object :DiffUtil.ItemCallback<HotelByNameItem>(){
        override fun areItemsTheSame(oldItem: HotelByNameItem, newItem: HotelByNameItem): Boolean {
            return oldItem.hotelName == newItem.hotelName
        }

        override fun areContentsTheSame(
            oldItem: HotelByNameItem,
            newItem: HotelByNameItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    //takes two lists and calculates the differences async
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HotelListAdapter.HotelViewHolder {
        return HotelViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_hotel_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        //get current hotel
        val hotel = differ.currentList[position]
        holder.itemView.apply {
            hotel_name.text = hotel.hotelName
            hotel_address.text = hotel.address.addressNameEdited
            hotel_desc.text = hotel.description
            setOnClickListener {
                onItemClickListener?.let { it(hotel) }  //"it" refers to onItemClickListener on which the item is clicked
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((HotelByNameItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (HotelByNameItem) -> Unit) {
        onItemClickListener = listener
    }
}