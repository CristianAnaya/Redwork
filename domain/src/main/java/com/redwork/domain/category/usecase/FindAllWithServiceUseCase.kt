package com.redwork.domain.category.usecase

import com.redwork.domain.R.string.empty_category
import com.redwork.domain.category.model.Category
import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FindAllWithServiceUseCase (private val repository: CategoryRepository) {

    operator fun invoke(): Flow<Resource<List<Category>>> {
        return repository.getCategoriesWithServices().map { resource ->
            if (resource is Resource.Success && resource.data.isEmpty()) {
                Resource.Failure(UiText.StringResource(empty_category))
            } else {
                resource
            }
        }
    }
}