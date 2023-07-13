package com.redwork.domain.auth.usecase

import com.redwork.domain.auth.repository.AuthRepository

class GetFirstTimeUseCase (private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.getFirstTime()
}