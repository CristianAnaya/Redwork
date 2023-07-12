package com.redwork.domain.auth.usecase

import com.redwork.domain.R.string.empty_param
import com.redwork.domain.R.string.invalid_email
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.Register
import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText

class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(register: Register): Resource<Auth> {
        val validationError = validateRegister(register)
        return if (validationError != null) {
            Resource.Failure(validationError)
        } else {
            repository.register(register)
        }
    }

    private fun validateRegister(register: Register): UiText? {
        if (register.name.isBlank() ||
            register.lastName.isBlank() ||
            register.email.isBlank() ||
            register.phone.isBlank()
        ) {
            return UiText.StringResource( empty_param)
        }

        if (!register.email.contains("@")) {
            return UiText.StringResource(invalid_email)
        }

        return null
    }

}