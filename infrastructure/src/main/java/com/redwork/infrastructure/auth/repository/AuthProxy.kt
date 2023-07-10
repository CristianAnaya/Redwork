package com.redwork.infrastructure.auth.repository

import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R
import com.redwork.infrastructure.R.string.unexpected_error_login
import com.redwork.infrastructure.auth.repository.contracts.AuthDataSourceRepository
import com.redwork.infrastructure.auth.repository.contracts.AuthRemoteRepository
import com.redwork.infrastructure.auth.repository.contracts.AuthTemporalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthProxy(
    private val dataSourceRepository: AuthDataSourceRepository,
    private val remoteRepository: AuthRemoteRepository,
    private val temporalRepository: AuthTemporalRepository
): AuthRepository {

    override fun getOTP(phone: String, country: String): Flow<Resource<String>> {
        return dataSourceRepository.getOTP(phone, country)
    }

    override fun loginWithOTP(
        phone: String,
        code: String,
        verificationId: String
    ): Flow<Resource<Auth>> = flow {
        dataSourceRepository.loginWithOTP(phone, code, verificationId).collect {
            it.run {
                when(this) {
                    is Resource.Success -> {
                        val loginResult = remoteRepository.login(phone = this.data)

                        if (loginResult is Resource.Success) {
                            val auth = loginResult.data
                            temporalRepository.saveSession(auth)
                        }

                        emit(loginResult)
                    }
                    is Resource.Failure -> {
                        emit(Resource.Failure(message))
                    }
                    else -> {
                        emit(Resource.Failure(UiText.StringResource(unexpected_error_login)))
                    }
                }
            }
        }
    }


    override fun getSession(auth: Auth): Flow<Resource<Auth>> {
        TODO("Not yet implemented")
    }

}