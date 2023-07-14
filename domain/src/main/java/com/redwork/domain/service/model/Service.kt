package com.redwork.domain.service.model

data class Service(
    val id: Int,
    val name: String,
    val idCategory: Int,
    var isSelected: Boolean = false
)
