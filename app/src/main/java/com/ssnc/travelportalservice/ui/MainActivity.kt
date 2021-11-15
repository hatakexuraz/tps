package com.ssnc.travelportalservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgs
import androidx.navigation.ui.setupWithNavController
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.repository.HotelRepository
import com.ssnc.travelportalservice.util.PreferenceManager
import com.ssnc.travelportalservice.viewmodel.HotelViewModel
import com.ssnc.travelportalservice.viewmodel.HotelViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var hotelViewModel: HotelViewModel
    lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_TravelPortalService)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        preferenceManager = PreferenceManager.newInstance(this)
//        Log.d("Fragment", "Main NeedTutorial: ${preferenceManager.needTutorial}")

        val hotelRepo = HotelRepository()
        val viewModelProviderFactory = HotelViewModelProviderFactory(hotelRepo)
        hotelViewModel = ViewModelProvider(this, viewModelProviderFactory).get(HotelViewModel::class.java)

        //findNavController() does not work with the onCreate method so it requires the below lines
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.hotelDetailFragment -> {
//                    toolbar.visibility = View.GONE
                    bottom_nav_view.visibility = View.GONE
                }
            }
        }

        bottom_nav_view.setupWithNavController(navController)
    }
}