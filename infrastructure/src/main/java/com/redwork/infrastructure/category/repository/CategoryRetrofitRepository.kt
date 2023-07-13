package com.redwork.infrastructure.category.repository

import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource
import com.redwork.infrastructure.category.httpclient.services.CategoryService
import com.redwork.infrastructure.category.mapper.toCategory
import com.redwork.infrastructure.category.repository.contracts.CategoryRemoteRepository
import com.redwork.infrastructure.core.http_client.commons.ResponseToRequest

class CategoryRetrofitRepository(private val categoryService: CategoryService): CategoryRemoteRepository{

    override suspend fun getCategories(): Resource<List<Category>> {
        val service = categoryService.getCategories()
        return ResponseToRequest.send(service) { categoryDto ->
            categoryDto.map { it.toCategory() }
        }
    }

    override suspend fun getCategoriesWithServices(): Resource<List<Category>> {
        val service = categoryService.getCategoriesWithServices()
        return ResponseToRequest.send(service) { categoryDto ->
            categoryDto.map { it.toCategory() }
        }
    }

}