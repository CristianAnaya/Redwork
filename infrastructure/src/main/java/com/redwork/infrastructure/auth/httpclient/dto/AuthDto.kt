package com.redwork.infrastructure.auth.httpclient.dto

import com.google.gson.Gson
import com.redwork.infrastructure.user.network.dto.UserDto

data class AuthDto(
    val user: UserDto?= null,
    val token: String? = null
) {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AuthDto = Gson().fromJson(data, AuthDto::class.java)
    }

}
