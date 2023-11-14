package com.redwork.domain.address.repository

import com.redwork.domain.address.model.Address
import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    fun getAddress(): Flow<Address?>
    suspend fun save(address: Address): Resource<Unit>
}