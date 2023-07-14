package com.redwork.domain.category.usecase

import com.redwork.domain.category.model.Category
import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

class GetSelectedCategoriesUseCase(private val repository: CategoryRepository) {
    operator fun invoke(): Flow<List<Category>> {
        return repository.getSelectedCategories()
    }
}