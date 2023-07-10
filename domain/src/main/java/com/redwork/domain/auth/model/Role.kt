package com.redwork.domain.auth.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Role(
    val id: String,
    val name: String,
    val image: String,
    val route: String,
) {
    fun toJson(): String = Gson().toJson(Role(
        id,
        name,
        if (image.isNotBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        route
    ))

    companion object {
        fun fromJson(data: String): Role = Gson().fromJson(data, Role::class.java)
    }
}
