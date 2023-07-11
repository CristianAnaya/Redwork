package com.redwork.infrastructure.auth.mapper

import com.redwork.domain.auth.model.Auth
import com.redwork.infrastructure.auth.network.dto.AuthDto
import com.redwork.infrastructure.user.mapper.toUser
import com.redwork.infrastructure.user.mapper.toUserDto

fun AuthDto.toAuth(): Auth {
    return Auth(
        user = user?.toUser(),
        token = token
    )
}

fun Auth.toAuthDto(): AuthDto {
    return AuthDto(
        user = user?.toUserDto(),
        token = token ?: ""
    )
}