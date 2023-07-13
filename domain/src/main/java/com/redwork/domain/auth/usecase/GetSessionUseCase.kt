package com.redwork.domain.auth.usecase

import com.redwork.domain.auth.repository.AuthRepository

class GetSessionUseCase(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSession()
}