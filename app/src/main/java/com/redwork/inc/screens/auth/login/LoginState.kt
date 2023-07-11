package com.redwork.inc.screens.auth.login

data class LoginState(
    val phone: String = "",
    val country: String = "",
    val otp: String = "",
    val validationId: String = ""
)
