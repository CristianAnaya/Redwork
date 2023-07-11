package com.redwork.infrastructure.auth.repository.contracts

import android.app.Activity
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

interface AuthDataSourceRepository {
    fun getOTP(phone: String, country: String, context: Activity): Flow<Resource<String>>
    fun loginWithOTP(
        phone: String,
        code: String,
        verificationId: String,
    ): Flow<Resource<String>>
}