package com.ssnc.travelportalservice.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.util.PreferenceManager

class SplashFragment : Fragment(R.layout.fragment_splash) {

    lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Fragment", "Splash Fragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferenceManager = PreferenceManager.newInstance(requireContext())

        navigateToNextScreen()
    }

    private fun navigateToNextScreen() {
        val needTutorial = preferenceManager.needTutorial
        Log.d("Fragment", "Splash NeedTutorial: $needTutorial")
        if (needTutorial) {
//            preferenceManager.needTutorial = false
            val directions = SplashFragmentDirections.actionSplashFragmentToWalkThroughFragment2()
            findNavController().navigate(directions)
        } else {
            val directions = SplashFragmentDirections.actionSplashFragmentToMainActivity()
            findNavController().navigate(directions)
        }
    }
}