package com.ssnc.travelportalservice.util

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

object Utils {

    private val EXTERNAL_STORAGE_PERMISSION = 1

    fun requestStoragePermission(fragment: Fragment?, onResult: OnResult?) {
        fragment?.let {
            if (it.context == null) {
                return@let
            }
            if (ContextCompat.checkSelfPermission(it.requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                fragment.requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    EXTERNAL_STORAGE_PERMISSION
                )
            } else {
                onResult?.isGranted()
            }
        }
    }

    interface OnResult {
        fun isGranted()
    }
}