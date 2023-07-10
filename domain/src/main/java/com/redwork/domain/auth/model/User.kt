package com.redwork.domain.auth.model

data class User(
    val id: String? = null,
    var name: String,
    var lastname: String,
    val email: String? = null,
    var phone: String,
    var image: String? = null,
    val roles: List<Role>? = null,
)
