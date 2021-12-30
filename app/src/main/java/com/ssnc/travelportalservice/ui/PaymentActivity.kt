package com.ssnc.travelportalservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.esewa.android.sdk.payment.ESewaConfiguration
import com.esewa.android.sdk.payment.ESewaPayment
import com.esewa.android.sdk.payment.ESewaPaymentActivity
import com.ssnc.travelportalservice.R

class PaymentActivity : AppCompatActivity() {

//    private lateinit var binding : ActivityPaymentBinding

    val merchant_id="JB0BBQ4aD0UqIThFJwAKBgAXEUkEGQUBBAwdOgABHD4DChwUAB0R"
    val merchant_secret_key="BhwIWQQADhIYSxILExMcAgFXFhcOBwAKBgAXEQ=="
    val eSewaConfiguration: ESewaConfiguration = ESewaConfiguration()
        .clientId(merchant_id)
        .secretKey(merchant_secret_key)
        .environment(ESewaConfiguration.ENVIRONMENT_TEST)
    val REQUEST_CODE_PAYMENT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityPaymentBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_payment)

        val eSewaPayment: ESewaPayment = ESewaPayment("10",
            "test_payment", "test_productId", "http://chandrama.com/")

        val intent: Intent = Intent(this, ESewaPaymentActivity::class.java)
        intent.putExtra(ESewaConfiguration.ESEWA_CONFIGURATION, eSewaConfiguration)

        intent.putExtra(ESewaPayment.ESEWA_PAYMENT, eSewaPayment)
        startActivityForResult(intent, REQUEST_CODE_PAYMENT)
    }


    //checks the result of transaction
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PAYMENT) {
            if (resultCode == RESULT_OK) {
                val s = data!!.getStringExtra(ESewaPayment.EXTRA_RESULT_MESSAGE)
                if (s != null) {
                    Log.i("Proof of Payment", s)
                }
                Toast.makeText(this, "SUCCESSFUL PAYMENT", Toast.LENGTH_SHORT).show()
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled By User", Toast.LENGTH_SHORT).show()
                this.finish()
            } else if (resultCode == ESewaPayment.RESULT_EXTRAS_INVALID) {
                val s = data!!.getStringExtra(ESewaPayment.EXTRA_RESULT_MESSAGE)
                if (s != null) {
                    Log.i("Proof of Payment", s)
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}