package com.redwork.infrastructure.category.mapper

import com.redwork.domain.category.model.Category
import com.redwork.infrastructure.category.httpclient.dto.CategoryDto
import com.redwork.infrastructure.service.mapper.toService
import com.redwork.infrastructure.service.mapper.toServiceDto

fun Category.toCategoryDto(): CategoryDto {
    return CategoryDto(
        id,
        name,
        route,
        services?.map { it.toServiceDto() } ?: emptyList()
    )
}

fun CategoryDto.toCategory(): Category {
    return Category(
        id,
        name,
        route,
        services?.map { it.toService() } ?: emptyList()
    )
}