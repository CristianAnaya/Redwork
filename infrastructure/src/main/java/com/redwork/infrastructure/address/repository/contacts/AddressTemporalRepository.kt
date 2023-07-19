package com.redwork.infrastructure.address.repository.contacts

import com.redwork.domain.address.model.Address
import com.redwork.domain.core.Resource
import kotlinx.coroutines.flow.Flow

interface AddressTemporalRepository {
    fun getAddress(): Flow<Address>
    suspend fun save(address: Address): Resource<Unit>
}