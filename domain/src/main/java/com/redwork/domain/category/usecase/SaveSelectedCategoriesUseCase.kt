package com.redwork.domain.category.usecase

import com.redwork.domain.category.model.Category
import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.domain.core.Resource

class SaveSelectedCategoriesUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke(categories: List<Category>): Resource<Unit> = repository.saveSelectedCategories(categories)
}
