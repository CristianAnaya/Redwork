package com.redwork.infrastructure.auth.mapper

import com.redwork.domain.auth.model.Register
import com.redwork.infrastructure.auth.httpclient.dto.RegisterDto

fun Register.toRegisterDto(): RegisterDto {
    return RegisterDto(
        name,
        lastName,
        email,
        phone,
        idRole,
        selectedService
    )
}

fun RegisterDto.toRegister(): Register {
    return Register(
        name,
        lastname,
        email,
        phone,
        idRole,
        selectedService
    )
}