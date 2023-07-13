package com.redwork.infrastructure.auth.httpclient.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegisterDto(
    val name: String,
    val lastname: String,
    val email: String,
    val phone: String,
    @SerializedName("rolesIds") val idRole: List<String>,
    @SerializedName("selected_service") val selectedService: List<String>? = null
): Serializable