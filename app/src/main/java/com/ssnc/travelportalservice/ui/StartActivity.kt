package com.ssnc.travelportalservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.fragments.WalkThroughFragment
import com.ssnc.travelportalservice.ui.fragments.WalkThroughFragmentDirections
import com.ssnc.travelportalservice.util.PreferenceManager

class StartActivity : AppCompatActivity() {

    lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        Log.d("Fragment", "Start Activity")

        val navHostFrag = supportFragmentManager.findFragmentById(R.id.container_start) as NavHostFragment
        val navController = navHostFrag.navController
        navController.setGraph(R.navigation.nav_graph_start)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        preferenceManager = PreferenceManager.newInstance(this)
    }
}