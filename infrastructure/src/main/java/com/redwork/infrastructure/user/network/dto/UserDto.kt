package com.redwork.infrastructure.user.network.dto

import com.google.gson.annotations.SerializedName
import com.redwork.infrastructure.auth.network.dto.RoleDto

data class UserDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone") val phone: String,
    @SerializedName("image") val image: String? = null,
    @SerializedName("roles") val roles: List<RoleDto>? = null,
)
