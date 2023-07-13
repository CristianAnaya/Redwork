package com.redwork.infrastructure.service.network.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ServiceDto(
    val id: Int,
    val name: String,
    @SerializedName("id_category") val idCategory: Int
): Serializable
