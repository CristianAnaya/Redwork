package com.redwork.domain.auth.usecase

import com.redwork.domain.auth.model.RegisterInfo
import com.redwork.domain.auth.repository.AuthRepository

class SaveInfoToWorkerUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(
        id: String, registerInfo: RegisterInfo
    ) = repository.saveInfoToWorker(id, registerInfo)
}