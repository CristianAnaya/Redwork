package com.redwork.infrastructure.category.repository.contracts

import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource

interface CategoryRemoteRepository {
    suspend fun getCategories(): Resource<List<Category>>
    suspend fun getCategoriesWithServices(): Resource<List<Category>>
}