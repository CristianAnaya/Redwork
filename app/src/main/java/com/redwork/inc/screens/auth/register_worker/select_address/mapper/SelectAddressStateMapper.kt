package com.redwork.inc.screens.auth.register_worker.select_address.mapper

import com.redwork.domain.address.model.Address
import com.redwork.inc.screens.auth.register_worker.select_address.SelectAddressState

fun SelectAddressState.toAddress() : Address {
    return Address(
        address,
        latitude,
        longitude
    )
}