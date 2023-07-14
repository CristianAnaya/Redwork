package com.redwork.infrastructure.category.repository.contracts

import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryTemporalRepository {
    fun getSelectedCategories(): Flow<List<Category>>
    suspend fun saveSelectedCategories(categories: List<Category>): Resource<Unit>
}