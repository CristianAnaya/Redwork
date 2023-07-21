package com.redwork.infrastructure.user.mapper

import com.redwork.domain.auth.model.User
import com.redwork.infrastructure.address.mapper.toAddress
import com.redwork.infrastructure.address.mapper.toAddressDto
import com.redwork.infrastructure.auth.mapper.toRol
import com.redwork.infrastructure.auth.mapper.toRolDto
import com.redwork.infrastructure.user.network.dto.UserDto

fun UserDto.toUser(): User {
    return User(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        image = image,
        roles = roles?.map { it.toRol() },
        address = address?.map { it.toAddress() }
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        image = image,
        roles = roles?.map { it.toRolDto() },
        address = address?.map { it.toAddressDto() }
    )
}