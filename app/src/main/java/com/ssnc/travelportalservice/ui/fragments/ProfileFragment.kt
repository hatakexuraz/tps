package com.ssnc.travelportalservice.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ssnc.travelportalservice.R
import com.ssnc.travelportalservice.util.Utils
import kotlinx.android.synthetic.main.activity_main.*

class ProfileFragment : Fragment(R.layout.fragment_profile), View.OnClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(view: View?) {
        if (view == null) return
        when(view.id) {
            R.id.user_image -> {
                checkPermissions()
            }
        }
    }

    private fun checkPermissions() {
        val rExtStorePermission = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
        val wExtStorePermission = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val cameraPermission = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
        if (rExtStorePermission != PackageManager.PERMISSION_GRANTED || wExtStorePermission != PackageManager.PERMISSION_GRANTED || cameraPermission != PackageManager.PERMISSION_GRANTED) {
            Utils.requestStoragePermission(this, object : Utils.OnResult {
                override fun isGranted() {
                    checkPermissions()
                }
            })
            return
        }
        if (!Settings.System.canWrite(context)) {
            //Show dialog to user that the permission is not granted
        } else {
            val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()){
                if (it) {
                }
            }
        }
    }
}