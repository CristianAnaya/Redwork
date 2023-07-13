package com.redwork.infrastructure.service.mapper

import com.redwork.domain.service.model.Service
import com.redwork.infrastructure.service.network.dto.ServiceDto

fun Service.toServiceDto(): ServiceDto {
    return ServiceDto(
        id,
        name,
        idCategory
    )
}

fun ServiceDto.toService(): Service {
    return Service(
        id,
        name,
        idCategory
    )
}