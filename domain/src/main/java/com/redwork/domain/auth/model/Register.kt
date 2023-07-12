package com.redwork.domain.auth.model

data class Register(
    val name: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val idRole: List<String>,
    val selectedService: List<String>? = null
)
