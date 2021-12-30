package com.ssnc.travelportalservice.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.esewa.android.sdk.payment.ESewaConfiguration
import com.esewa.android.sdk.payment.ESewaPayment
import com.esewa.android.sdk.payment.ESewaPaymentActivity
import com.ssnc.travelportalservice.R

class PaymentProcessingScreen : Fragment(R.layout.fragment_payment_screen) {

    val merchant_id="JB0BBQ4aD0UqIThFJwAKBgAXEUkEGQUBBAwdOgABHD4DChwUAB0R"
    val merchant_secret_key="BhwIWQQADhIYSxILExMcAgFXFhcOBwAKBgAXEQ=="
    val eSewaConfiguration: ESewaConfiguration = ESewaConfiguration()
        .clientId(merchant_id)
        .secretKey(merchant_secret_key)
        .environment(ESewaConfiguration.ENVIRONMENT_TEST)
    val REQUEST_CODE_PAYMENT = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eSewaPayment: ESewaPayment = ESewaPayment("10",
            "test_payment", "test_productId", "http://chandrama.com/")

        val intent: Intent = Intent(context, ESewaPaymentActivity::class.java)
        intent.putExtra(ESewaConfiguration.ESEWA_CONFIGURATION, eSewaConfiguration)

        intent.putExtra(ESewaPayment.ESEWA_PAYMENT, eSewaPayment)
        startActivityForResult(intent, REQUEST_CODE_PAYMENT)
    }


    //checks the result of transaction
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PAYMENT) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                val s = data!!.getStringExtra(ESewaPayment.EXTRA_RESULT_MESSAGE)
                if (s != null) {
                    Log.i("Proof of Payment", s)
                }
                Toast.makeText(context, "SUCCESSFUL PAYMENT", Toast.LENGTH_SHORT).show()
            } else if (resultCode == AppCompatActivity.RESULT_CANCELED) {
                Toast.makeText(context, "Canceled By User", Toast.LENGTH_SHORT).show()
            } else if (resultCode == ESewaPayment.RESULT_EXTRAS_INVALID) {
                val s = data!!.getStringExtra(ESewaPayment.EXTRA_RESULT_MESSAGE)
                if (s != null) {
                    Log.i("Proof of Payment", s)
                }
            }
        }
    }
}