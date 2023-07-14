package com.redwork.infrastructure.category.httpclient.services

import com.redwork.infrastructure.category.httpclient.dto.CategoryDto
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("category")
    suspend fun getCategories(): Response<List<CategoryDto>>

    @GET("category/services")
    suspend fun getCategoriesWithServices(): Response<List<CategoryDto>>

}