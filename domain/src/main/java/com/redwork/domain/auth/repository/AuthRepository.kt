package com.redwork.domain.auth.repository

import android.app.Activity
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.Register
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun getOTP(phone: String, country: String, context: Activity): Flow<Resource<String>>
    fun loginWithOTP(
        phone: String,
        code: String,
        verificationId: String): Flow<Resource<Auth>>
    suspend fun register(register: Register): Resource<Auth>
    fun getSession(): Flow<Auth>
    suspend fun firstTime(status: Boolean)
    suspend fun getFirstTime(): Boolean
}