package com.redwork.infrastructure.auth.mapper

import com.redwork.domain.auth.model.Role
import com.redwork.infrastructure.auth.network.dto.RoleDto


fun RoleDto.toRol(): Role {
    return Role(
        id = id,
        name = name,
        image = image,
        route = route
    )
}

fun Role.toRolDto(): RoleDto {
    return RoleDto(
        id = id,
        name = name,
        image = image,
        route = route
    )
}