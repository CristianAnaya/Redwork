package com.redwork.inc.components.country_code.data

import com.redwork.inc.R
import java.util.Locale


data class CountryData(
    private var cCodes: String,
    val countryPhoneCode: String = "+57",
    val cNames:String = "tr",
    val flagResID: Int = R.drawable.tr
) {
    val countryCode = cCodes.lowercase(Locale.getDefault())
}