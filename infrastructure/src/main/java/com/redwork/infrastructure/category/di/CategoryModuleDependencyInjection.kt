package com.redwork.infrastructure.category.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.infrastructure.category.httpclient.services.CategoryService
import com.redwork.infrastructure.category.repository.CategoryDataStorePreferencesRepository
import com.redwork.infrastructure.category.repository.CategoryProxy
import com.redwork.infrastructure.category.repository.CategoryRetrofitRepository
import com.redwork.infrastructure.category.repository.contracts.CategoryRemoteRepository
import com.redwork.infrastructure.category.repository.contracts.CategoryTemporalRepository
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
    @Singleton
    fun provideCategoryTemporalRepository(
        dataStore: DataStore<Preferences>
    ): CategoryTemporalRepository = CategoryDataStorePreferencesRepository(dataStore)

    @Provides
    fun provideCategoryRemoteRepository(
        categoryService: CategoryService
    ): CategoryRemoteRepository = CategoryRetrofitRepository(categoryService = categoryService)

    @Provides
    fun provideCategoryRepository(
        remoteRepository: CategoryRemoteRepository,
        temporalRepository: CategoryTemporalRepository
    ): CategoryRepository = CategoryProxy(
        remoteRepository = remoteRepository,
        temporalRepository = temporalRepository
    )

}