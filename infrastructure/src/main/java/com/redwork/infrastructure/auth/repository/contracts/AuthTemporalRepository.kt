package com.redwork.infrastructure.auth.repository.contracts

import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.User
import kotlinx.coroutines.flow.Flow

interface AuthTemporalRepository {
    suspend fun saveSession(auth: Auth)
    fun getSessionData(): Flow<Auth>
    suspend fun updateSessionData(user: User)
    suspend fun logout()
}