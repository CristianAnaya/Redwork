package com.redwork.infrastructure.auth.network.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegisterDto(
    val name: String,
    val lastName: String,
    val email: String,
    val phone: String,
    @SerializedName("id_role") val idRole: List<String>,
    @SerializedName("selected_service") val selectedService: List<String>? = null
): Serializable