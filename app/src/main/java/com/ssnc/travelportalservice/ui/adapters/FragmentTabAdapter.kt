package com.ssnc.travelportalservice.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ssnc.travelportalservice.ui.fragments.BookingOverViewFragment
import com.ssnc.travelportalservice.ui.fragments.BookingUserInfoFragment

class FragmentTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val TAB_COUNT = 2

    override fun getItemCount() = TAB_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BookingUserInfoFragment.newInstance()
            1 -> BookingOverViewFragment.newInstance()
            else -> BookingUserInfoFragment.newInstance()
        }
    }
}