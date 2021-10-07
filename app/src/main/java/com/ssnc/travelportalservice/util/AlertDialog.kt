package com.ssnc.travelportalservice.util

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ssnc.travelportalservice.R

class AlertDialog private constructor(item : ItemDialog): DialogFragment() {
    private val mTitle = item.title
    private val mMessage = item.message
    private val mPositive = item.positiveText
    private val mPositiveListener = item.positiveListener
    private val mNeedNegative = item.needNegative
    private val mNegative = item.negativeText
    private val mNegativeListener = item.negativeListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        if (TextUtils.isEmpty(mTitle)) {
            return if (!mNeedNegative) {
                AlertDialog.Builder(requireContext(), R.style.AlertDialogCustom)
                    .setMessage(mMessage)
                    .setPositiveButton(mPositive, mPositiveListener)
                    .create()
            } else {
                AlertDialog.Builder(requireContext(), R.style.AlertDialogCustom)
                    .setMessage(mMessage)
                    .setPositiveButton(mPositive, mPositiveListener)
                    .setNegativeButton(mNegative, mNegativeListener)
                    .create()
            }
        } else {
            return if (!mNeedNegative) {
                AlertDialog.Builder(requireContext(), R.style.AlertDialogCustom)
                    .setTitle(mTitle)
                    .setMessage(mMessage)
                    .setPositiveButton(mPositive, mPositiveListener)
                    .create()
            } else {
                AlertDialog.Builder(requireContext(), R.style.AlertDialogCustom)
                    .setTitle(mTitle)
                    .setMessage(mMessage)
                    .setPositiveButton(mPositive, mPositiveListener)
                    .setNegativeButton(mNegative, mNegativeListener)
                    .create()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }

    companion object{
        val TAG = "dialog"

        fun newInstance(item: ItemDialog): com.ssnc.travelportalservice.util.AlertDialog {
            return AlertDialog(item)
        }

        fun removeFragment(fragmentManager: FragmentManager?, tag: String) {
            if (fragmentManager == null) return
            val prev = fragmentManager.findFragmentByTag(tag) ?: return
            if (prev is DialogFragment) {
                val dialog = prev.dialog
                if (dialog != null && dialog.isShowing) {
                    dialog.dismiss()
                    prev.onDismiss(dialog)
                }
            }
            val ft= fragmentManager.beginTransaction()
            ft.remove(prev)
            ft.commitAllowingStateLoss()
            Handler(Looper.getMainLooper()).post {
                fragmentManager.executePendingTransactions()
            }
        }
    }
}

data class ItemDialog(
    val title : String? = null,
    val message : String,
    val positiveText : String,
    val positiveListener : DialogInterface.OnClickListener,
    val needNegative : Boolean = false,
    val negativeText : String? = null,
    val negativeListener : DialogInterface.OnClickListener? = null
)