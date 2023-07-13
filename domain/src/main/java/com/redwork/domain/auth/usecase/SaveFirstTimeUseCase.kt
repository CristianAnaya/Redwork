package com.redwork.domain.auth.usecase

import com.redwork.domain.auth.repository.AuthRepository

class SaveFirstTimeUseCase (private val repository: AuthRepository) {
    suspend operator fun invoke(status: Boolean) = repository.firstTime(status)
}