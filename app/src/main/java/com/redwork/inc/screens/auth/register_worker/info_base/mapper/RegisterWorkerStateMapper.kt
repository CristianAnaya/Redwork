package com.redwork.inc.screens.auth.register_worker.info_base.mapper

import com.redwork.domain.auth.model.Register
import com.redwork.inc.screens.auth.register_worker.info_base.RegisterWorkerState

fun RegisterWorkerState.toRegister(): Register {
    return Register(
        name = name,
        lastName = lastname,
        email = email,
        phone = phone,
        idRole = role.toList()
    )
}