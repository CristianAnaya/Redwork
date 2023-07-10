package com.redwork.co.screens.auth.login

data class LoginState(
    val phone: String = "",
    val country: String = "",
    val otp: String = "",
    val validationId: String = ""
)
