package com.redwork.co.screens.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.farhanroy.cccp.CCPCountry
import io.github.farhanroy.cccp.getLibraryMasterCountriesEnglish
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var loginResource by mutableStateOf<Resource<Auth>?>(null)
        private set

    var phone by mutableStateOf("")
    var otp by mutableStateOf("")
    var otpSent by mutableStateOf(false)
    var country: CCPCountry = getLibraryMasterCountriesEnglish().first()

    fun onPhoneInput(value: String) {
        phone = value
    }

    fun onOTPInput(value: String) {
        otp = value
    }
}