package com.redwork.infrastructure.auth.mapper

import com.redwork.domain.auth.model.Role
import com.redwork.infrastructure.auth.httpclient.dto.RoleDto


fun RoleDto.toRol(): Role {
    return Role(
        id = id,
        name = name,
    )
}

fun Role.toRolDto(): RoleDto {
    return RoleDto(
        id = id,
        name = name
    )
}