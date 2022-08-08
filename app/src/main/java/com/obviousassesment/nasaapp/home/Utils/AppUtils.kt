package com.obviousassesment.nasaapp.home.Utils

import android.content.res.Resources

object AppUtils {

    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}