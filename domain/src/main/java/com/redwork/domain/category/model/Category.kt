package com.redwork.domain.category.model

import com.redwork.domain.service.model.Service

data class Category(
    val id: Int,
    val name: String,
    val route: String,
    val service: List<Service>
)