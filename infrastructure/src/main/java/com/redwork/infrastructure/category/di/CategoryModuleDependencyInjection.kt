package com.redwork.infrastructure.category.di

import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.infrastructure.category.httpclient.services.CategoryService
import com.redwork.infrastructure.category.repository.CategoryProxy
import com.redwork.infrastructure.category.repository.CategoryRetrofitRepository
import com.redwork.infrastructure.category.repository.contracts.CategoryRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit): CategoryService {
        return retrofit.create(CategoryService::class.java)
    }

    @Provides
    fun provideCategoryRemoteRepository(
        categoryService: CategoryService
    ): CategoryRemoteRepository = CategoryRetrofitRepository(categoryService = categoryService)

    @Provides
    fun provideCategoryRepository(
        remoteRepository: CategoryRemoteRepository,
    ): CategoryRepository = CategoryProxy(
        remoteRepository = remoteRepository
    )

}