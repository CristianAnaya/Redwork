package com.redwork.infrastructure.category.httpclient.dto

import com.redwork.infrastructure.service.network.dto.ServiceDto
import java.io.Serializable

data class CategoryDto(
    val id: Int,
    val name: String,
    val route: String,
    val services: List<ServiceDto>
): Serializable
