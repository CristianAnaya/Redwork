package com.redwork.infrastructure.auth.repository

import android.util.Log
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.User
import com.redwork.domain.core.Resource
import com.redwork.infrastructure.auth.mapper.toAuth
import com.redwork.infrastructure.auth.network.service.AuthService
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

    override suspend fun register(user: User): Resource<Auth> {
        TODO("Not yet implemented")
    }

}