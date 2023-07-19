package com.redwork.inc.screens.auth.register_worker.select_address

import com.google.maps.android.compose.MapProperties

data class SelectAddressState(
    val address: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)
