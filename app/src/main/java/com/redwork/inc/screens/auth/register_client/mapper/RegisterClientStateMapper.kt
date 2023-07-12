package com.redwork.inc.screens.auth.register_client.mapper

import com.redwork.domain.auth.model.Register
import com.redwork.inc.screens.auth.register_client.RegisterClientState

fun RegisterClientState.toRegister(): Register {
    return Register(
        name = name,
        lastName = lastname,
        email = email,
        phone = phone,
        idRole = role.toList()
    )
}