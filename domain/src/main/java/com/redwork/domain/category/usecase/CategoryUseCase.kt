package com.redwork.domain.category.usecase

data class CategoryUseCase(
    val findAll: FindAllUseCase,
    val findAllWithService: FindAllWithServiceUseCase,
    val getSelectedCategories: GetSelectedCategoriesUseCase,
    val saveSelectedCategories: SaveSelectedCategoriesUseCase
)
