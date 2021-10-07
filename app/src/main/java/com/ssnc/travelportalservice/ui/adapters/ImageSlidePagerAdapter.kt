package com.ssnc.travelportalservice.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.fragments.ImageSlidePageFragment

class ImageSlidePagerAdapter(val fragment: Fragment) : FragmentStateAdapter(fragment) {

    val images = arrayListOf(R.drawable.background, R.drawable.manaslu, R.drawable.mandala, R.drawable.mustang, R.drawable.pagoda, R.drawable.pokhara, R.drawable.rara)

    override fun getItemCount(): Int {
        return images.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ImageSlidePageFragment(fragment)
        fragment.arguments = Bundle().apply {
            putInt("position",position+1)
            putInt("total", images.size)
            putInt("image", images[position])
        }
        return fragment
    }
}