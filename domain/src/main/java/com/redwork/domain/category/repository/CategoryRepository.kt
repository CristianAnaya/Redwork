package com.redwork.domain.category.repository

import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<Resource<List<Category>>>
    fun getCategoriesWithServices(): Flow<Resource<List<Category>>>
}