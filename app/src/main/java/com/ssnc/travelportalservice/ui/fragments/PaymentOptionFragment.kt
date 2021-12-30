package com.ssnc.travelportalservice.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.PaymentActivity
import kotlinx.android.synthetic.main.fragment_payment_option.*
import com.khalti.checkout.helper.PaymentPreference

import com.khalti.checkout.helper.Config

import com.khalti.checkout.helper.OnCheckOutListener
import com.ssnc.travelportalservice.util.Constant
import com.khalti.checkout.helper.KhaltiCheckOut
import com.khalti.widget.KhaltiButton

class PaymentOptionFragment : Fragment(R.layout.fragment_payment_option), View.OnClickListener {

    lateinit var khaltiCheckOut : KhaltiCheckOut

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lay_card.setOnClickListener(this)
        lay_esewa.setOnClickListener(this)
        lay_khalti.setOnClickListener(this)
//        khalti_button.setOnClickListener(this)

        val map: MutableMap<String, Any> = HashMap()
        map["merchant_extra"] = "This is extra data"

        val builder: Config.Builder =
            Config.Builder(Constant.khalti_key, "1234567890", "Hotel Booking Mountain", 1100L, object : OnCheckOutListener {
                override fun onError(action: String, errorMap: Map<String, String>) {
                    Toast.makeText(requireContext(), "Something went wrong. Try again", Toast.LENGTH_SHORT).show()
                }

                override fun onSuccess(data: Map<String, Any>) {
                    Toast.makeText(requireContext(), "Payment Successful", Toast.LENGTH_SHORT).show()
                }
            })
                .paymentPreferences(object : ArrayList<PaymentPreference?>() {
                    init {
                        add(PaymentPreference.KHALTI)
                    }
                })
                .additionalData(map)
                .productUrl("http://facebook.com")
//                .mobile("9800000000")

        val config : Config = builder.build()

//        khalti_button.setCheckOutConfig(config)m

        khaltiCheckOut = KhaltiCheckOut(requireContext(), config)
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when(view.id) {
            R.id.lay_esewa -> {
                val intent = Intent(context, PaymentActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
//                val action = PaymentOptionFragmentDirections.actionPaymentOptionsToPaymentProcessingScreen()
//                findNavController().navigate(action)
            }
            R.id.lay_khalti -> {
                Log.d("KhaltiCick","clicked on a button")
                khaltiCheckOut.show()
            }
            R.id.lay_card -> {
                val action = PaymentOptionFragmentDirections.actionPaymentOptionFragmentToCardAddFragment()
                findNavController().navigate(action)
            }
        }
    }
}