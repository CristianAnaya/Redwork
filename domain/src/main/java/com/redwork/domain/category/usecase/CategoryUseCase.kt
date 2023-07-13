package com.redwork.domain.category.usecase

data class CategoryUseCase(
    val findAll: FindAllUseCase,
    val findAllWithService: FindAllWithServiceUseCase
)
