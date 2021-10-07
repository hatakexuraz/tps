package com.ssnc.travelportalservice.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val sp: SharedPreferences = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)

    var needTutorial: Boolean = sp.getBoolean(WALKTHROUGH, true)
        set(value) {
            sp.edit()?.putBoolean(WALKTHROUGH, value)?.apply()
            field = value
        }

    companion object {
        private const val STORAGE = "tps"
        private const val WALKTHROUGH = "tutorial"
        private var instance: PreferenceManager? = null
        fun newInstance(context: Context) = instance?: synchronized(this) {
            instance?:PreferenceManager(context).also { instance = it }
        }
    }
}