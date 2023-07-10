package com.redwork.co.screens.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.farhanroy.cccp.CCPCountry
import io.github.farhanroy.cccp.getLibraryMasterCountriesEnglish
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var otpResource by mutableStateOf<Resource<String>?>(null)
        private set

    var loginResource by mutableStateOf<Resource<Auth>?>(null)
        private set

    var country: CCPCountry = getLibraryMasterCountriesEnglish().first()


    /**
     * Returns a non-nullable country code
     */
    private fun getCountryCode(): String {
        return "+${country.phoneCode}"
    }

    fun onValidationId(value: String) {
        state = state.copy(validationId = value)
    }

    fun onPhoneInput(value: String) {
        state = state.copy(phone = value)
    }

    fun onOTPInput(value: String) {
        state = state.copy(otp = value)
    }
}