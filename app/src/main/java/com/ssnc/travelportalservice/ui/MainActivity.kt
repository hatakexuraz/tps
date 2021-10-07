package com.ssnc.travelportalservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
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
        setContentView(R.layout.activity_main)
        Log.d("Fragment", "Main Activity")

        preferenceManager = PreferenceManager.newInstance(this)
        Log.d("Fragment", "Main NeedTutorial: ${preferenceManager.needTutorial}")

        val hotelRepo = HotelRepository()
        val viewModelProviderFactory = HotelViewModelProviderFactory(hotelRepo)
        hotelViewModel = ViewModelProvider(this, viewModelProviderFactory).get(HotelViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottom_nav_view.setupWithNavController(navController)
    }
}