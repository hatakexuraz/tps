package com.ssnc.travelportalservice.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.ui.MainActivity
import com.ssnc.travelportalservice.util.PreferenceManager
import kotlinx.android.synthetic.main.fragment_walkthrough.*

class WalkThroughFragment : Fragment(R.layout.fragment_walkthrough), View.OnClickListener {

    lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment", "Walkthrough Fragment")

        preferenceManager = PreferenceManager.newInstance(requireContext())

        val tutorialStatus = preferenceManager.needTutorial
        Log.d("Fragment", "Walk NeedTutorial: $tutorialStatus")
        val navController = findNavController()
        if (!tutorialStatus) {
            val startDestination = navController.graph.startDestination
            val navOption = NavOptions.Builder()
                .setPopUpTo(startDestination, true)
                .build()
            navController.navigate(startDestination, null, navOption)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tutorialStatus = preferenceManager.needTutorial
        Log.d("Fragment", "NeedTutorial: $tutorialStatus")
        if (!tutorialStatus) {
            val navController = findNavController()
            val startDestination = navController.graph.startDestination
            val navOption = NavOptions.Builder()
                .setPopUpTo(startDestination, true)
                .build()
            navController.navigate(startDestination, null, navOption)
        }

        btn_walk_next.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == null) return
        when (p0.id) {
            R.id.btn_walk_next -> {
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        preferenceManager.needTutorial = false
        val directions = WalkThroughFragmentDirections.actionWalkThroughFragmentToMainActivity()
        findNavController().navigate(directions)
    }
}