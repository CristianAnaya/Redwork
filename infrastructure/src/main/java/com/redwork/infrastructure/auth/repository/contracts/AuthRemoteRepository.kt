package com.redwork.infrastructure.auth.repository.contracts

import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.Register
import com.redwork.domain.core.Resource

interface AuthRemoteRepository {
    suspend fun login(phone: String): Resource<Auth>
    suspend fun register(register: Register): Resource<Auth>
}