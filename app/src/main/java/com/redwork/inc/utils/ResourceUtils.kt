package com.redwork.inc.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import java.util.Locale

object ResourceUtils {
    @SuppressLint("DiscouragedApi")
    fun getIconResourceId(iconName: String, context: Context): Int {
        Log.d("TAG", "getIconResourceId: ${iconName.lowercase(Locale.ROOT)}")
        val resources = context.resources
        return resources.getIdentifier(iconName.lowercase(Locale.ROOT), "drawable", context.packageName)
    }
}