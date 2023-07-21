package com.redwork.domain.auth.model

import com.redwork.domain.address.model.Address

data class User(
    val id: String? = null,
    var name: String,
    var lastname: String,
    val email: String? = null,
    var phone: String,
    var image: String? = null,
    val roles: List<Role>? = null,
    val address: List<Address>? = null,
)
