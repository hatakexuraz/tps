package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ssnc.travelportalservice.R
import kotlinx.android.synthetic.main.fragment_payment_option.*

class PaymentOptionFragment : Fragment(R.layout.fragment_payment_option), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lay_card.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when(view.id) {
            R.id.lay_card -> {
                val action = PaymentOptionFragmentDirections.actionPaymentOptionFragmentToCardAddFragment()
                findNavController().navigate(action)
            }
        }
    }
}