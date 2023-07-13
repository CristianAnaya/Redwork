package com.redwork.infrastructure.auth.httpclient.service

import com.redwork.infrastructure.auth.httpclient.dto.AuthDto
import com.redwork.infrastructure.auth.httpclient.dto.RegisterDto
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