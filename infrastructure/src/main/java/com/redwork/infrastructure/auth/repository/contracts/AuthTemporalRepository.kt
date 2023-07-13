package com.redwork.infrastructure.auth.repository.contracts

import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.User
import kotlinx.coroutines.flow.Flow

interface AuthTemporalRepository {
    suspend fun saveSession(auth: Auth)
    suspend fun fistTime(status: Boolean)
    fun getSessionData(): Flow<Auth>
    suspend fun getFirstTime(): Boolean
    suspend fun updateSessionData(user: User)
    suspend fun logout()
}