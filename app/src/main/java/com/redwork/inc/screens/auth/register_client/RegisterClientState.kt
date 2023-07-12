package com.redwork.inc.screens.auth.register_client

data class RegisterClientState(
    val name: String = "",
    val lastname: String = "",
    val email: String = "",
    val phone: String = "",
    val role: MutableList<String> = mutableListOf()
)