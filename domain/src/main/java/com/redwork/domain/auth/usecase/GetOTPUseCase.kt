package com.redwork.domain.auth.usecase

import android.app.Activity
import com.redwork.domain.R.string.empty_phone_parameter
import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetOTPUseCase(private val repository: AuthRepository) {

    operator fun invoke(phone: String, country: String, context: Activity): Flow<Resource<String>>{
        if (phone.isEmpty() || country.isEmpty()) {
            return flowOf(Resource.Failure(UiText.StringResource(empty_phone_parameter)))
        }

        return repository.getOTP(phone, country, context)
    }

}