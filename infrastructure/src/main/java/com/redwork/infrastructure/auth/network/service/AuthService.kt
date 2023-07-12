package com.redwork.infrastructure.auth.network.service

import com.redwork.domain.auth.model.Register
import com.redwork.infrastructure.auth.network.dto.AuthDto
import com.redwork.infrastructure.auth.network.dto.RegisterDto
import com.redwork.infrastructure.user.network.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("phone") email: String,
    ): Response<AuthDto>

    @POST("auth/register")
    suspend fun register(
        @Body() user: RegisterDto
    ): Response<AuthDto>

}