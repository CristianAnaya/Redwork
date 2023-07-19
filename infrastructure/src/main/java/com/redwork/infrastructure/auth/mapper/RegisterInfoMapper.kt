package com.redwork.infrastructure.auth.mapper

import com.redwork.domain.auth.model.RegisterInfo
import com.redwork.infrastructure.auth.httpclient.dto.RegisterInfoDto

fun RegisterInfo.toRegisterInfoDto(): RegisterInfoDto {
    return RegisterInfoDto(
        describeExperience,
        address,
        latitude,
        longitude,
        selectedCategories
    )
}
