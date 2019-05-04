package com.example.mvvm.extension

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mvvm.R

fun Fragment.showLoadingDialog(): AlertDialog? =
        activity?.let {
            AlertDialog.Builder(it).run {
                setView(R.layout.progress_dialog)
                setCancelable(false)
            }.create().apply {
                setCanceledOnTouchOutside(false)
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }