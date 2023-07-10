package com.redwork.infrastructure.auth.repository.contracts

import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.User
import com.redwork.domain.core.Resource

interface AuthRemoteRepository {
    suspend fun login(phone: String): Resource<Auth>
    suspend fun register(user: User): Resource<Auth>
}