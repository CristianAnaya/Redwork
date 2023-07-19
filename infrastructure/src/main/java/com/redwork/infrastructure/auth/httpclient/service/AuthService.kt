package com.redwork.infrastructure.auth.httpclient.service

import com.redwork.infrastructure.auth.httpclient.dto.AuthDto
import com.redwork.infrastructure.auth.httpclient.dto.RegisterDto
import com.redwork.infrastructure.auth.httpclient.dto.RegisterInfoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

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

    @PUT("auth/{id}")
    suspend fun registerToWorker(
        @Path("id") id: String,
        @Body() registerInfo: RegisterInfoDto,
    ): Response<AuthDto>
}