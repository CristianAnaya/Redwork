package com.redwork.infrastructure.auth.repository

import android.app.Activity
import android.util.Log
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.Register
import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R.string.there_is_not_network_connection
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

    override fun getOTP(phone: String, country: String, context: Activity): Flow<Resource<String>> {
        return dataSourceRepository.getOTP(phone, country, context)
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
                        try {
                            val loginResult = remoteRepository.login(phone = this.data)

                            if (loginResult is Resource.Success) {
                                val auth = loginResult.data
                                auth.user?.let { temporalRepository.saveSession(auth) }
                            }

                            emit(loginResult)
                        } catch (e: Exception) {
                            emit(Resource.Failure(UiText.StringResource(
                                there_is_not_network_connection
                            )))
                        }
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

    override suspend fun register(register: Register): Resource<Auth> {
        return try {
            val registerResult = remoteRepository.register(register)
            if (registerResult is Resource.Success) {
                val auth = registerResult.data
                temporalRepository.saveSession(auth)
            }
            registerResult
        } catch (e: Exception) {
            Log.d("AuthProxy", "register: ${e.message}")
            Resource.Failure(UiText.StringResource(there_is_not_network_connection))
        }
    }

    override fun getSession(): Flow<Auth> {
        return temporalRepository.getSessionData()
    }

    override suspend fun firstTime(status: Boolean) = temporalRepository.fistTime(status)

    override suspend fun getFirstTime(): Boolean = temporalRepository.getFirstTime()

}