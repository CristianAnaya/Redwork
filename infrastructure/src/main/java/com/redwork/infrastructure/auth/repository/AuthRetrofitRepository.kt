package com.redwork.infrastructure.auth.repository

import android.util.Log
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.Register
import com.redwork.domain.auth.model.RegisterInfo
import com.redwork.domain.core.Resource
import com.redwork.infrastructure.auth.mapper.toAuth
import com.redwork.infrastructure.auth.mapper.toRegisterDto
import com.redwork.infrastructure.auth.httpclient.service.AuthService
import com.redwork.infrastructure.auth.mapper.toRegisterInfoDto
import com.redwork.infrastructure.auth.repository.contracts.AuthRemoteRepository
import com.redwork.infrastructure.core.http_client.commons.ResponseToRequest

class AuthRetrofitRepository(private val authService: AuthService): AuthRemoteRepository {

    override suspend fun login(phone: String): Resource<Auth> {
        val response = authService.login(phone)
        return ResponseToRequest.send(response) { authResponse ->
            Log.d("AuthRetrofitRepository", "login: $authResponse")
            authResponse.toAuth()
        }
    }

    override suspend fun register(register: Register): Resource<Auth> {
        val response = authService.register(user = register.toRegisterDto())
        return ResponseToRequest.send(response) {
            it.toAuth()
        }
    }

    override suspend fun saveInfoToWorker(id: String, registerInfo: RegisterInfo): Resource<Auth> {
        val response = authService.registerToWorker(
            id = id,
            registerInfo = registerInfo.toRegisterInfoDto()
        )
        return ResponseToRequest.send(response) {
            it.toAuth()
        }
    }

}