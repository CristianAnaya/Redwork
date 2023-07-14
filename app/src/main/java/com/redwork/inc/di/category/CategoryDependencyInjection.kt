package com.redwork.inc.di.category

import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.domain.category.usecase.CategoryUseCase
import com.redwork.domain.category.usecase.FindAllUseCase
import com.redwork.domain.category.usecase.FindAllWithServiceUseCase
import com.redwork.domain.category.usecase.GetSelectedCategoriesUseCase
import com.redwork.domain.category.usecase.SaveSelectedCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CategoryDependencyInjection {

    @Provides
    fun provideCategoryUseCase(categoryRepository: CategoryRepository) = CategoryUseCase(
        findAll = FindAllUseCase(repository = categoryRepository),
        findAllWithService = FindAllWithServiceUseCase(repository = categoryRepository),
        getSelectedCategories = GetSelectedCategoriesUseCase(repository = categoryRepository),
        saveSelectedCategories = SaveSelectedCategoriesUseCase(repository = categoryRepository)
    )
}