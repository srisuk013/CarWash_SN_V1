package com.example.carwash_sn_v1.ui

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

fun Activity.hideSoftKeyboard() {
    currentFocus?.let {
        val imm = ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}
