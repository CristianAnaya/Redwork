package com.redwork.infrastructure.category.repository

import com.redwork.domain.category.model.Category
import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R.string.there_is_not_network_connection
import com.redwork.infrastructure.R.string.unexpected_error
import com.redwork.infrastructure.category.repository.contracts.CategoryRemoteRepository
import com.redwork.infrastructure.category.repository.contracts.CategoryTemporalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryProxy(
    private val remoteRepository: CategoryRemoteRepository,
    private val temporalRepository: CategoryTemporalRepository
): CategoryRepository {

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
        try {
            remoteRepository.getCategories().run {
                when (this) {
                    is Resource.Success -> {
                        val categories = this.data
                        emit(Resource.Success(categories))
                    }
                    is Resource.Failure -> {
                        emit(Resource.Failure(message))
                    }
                    else -> {
                        emit(Resource.Failure(UiText.StringResource(unexpected_error)))
                    }
                }
            }
        } catch (e: Exception) {
            emit(Resource.Failure(UiText.StringResource(there_is_not_network_connection)))
        }
    }

    override fun getCategoriesWithServices(): Flow<Resource<List<Category>>> = flow {
        try {
            remoteRepository.getCategoriesWithServices().run {
                when (this) {
                    is Resource.Success -> {
                        val categories = this.data
                        emit(Resource.Success(categories))
                    }
                    is Resource.Failure -> {
                        emit(Resource.Failure(message))
                    }
                    else -> {
                        emit(Resource.Failure(UiText.StringResource(unexpected_error)))
                    }
                }
            }
        } catch (e: Exception) {
            emit(Resource.Failure(UiText.StringResource(there_is_not_network_connection)))
        }
    }

    override fun getSelectedCategories(): Flow<List<Category>> = temporalRepository.getSelectedCategories()

    override suspend fun saveSelectedCategories(categories: List<Category>): Resource<Unit> = temporalRepository.saveSelectedCategories(categories)

}