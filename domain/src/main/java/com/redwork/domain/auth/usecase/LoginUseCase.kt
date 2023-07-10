package com.redwork.domain.auth.usecase

import com.redwork.domain.R
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class LoginUseCase(private val repository: AuthRepository) {

    operator fun invoke(
        phone: String,
        code: String,
        verificationId: String
    ): Flow<Resource<Auth>> {
        if (phone.isEmpty() || code.isEmpty() || verificationId.isEmpty()) {
            return flowOf(Resource.Failure(UiText.StringResource(R.string.unexpected_error)))
        }

        return repository.loginWithOTP(phone, code, verificationId)
    }

}