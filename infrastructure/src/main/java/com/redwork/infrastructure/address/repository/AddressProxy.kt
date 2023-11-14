package com.redwork.infrastructure.address.repository

import com.redwork.domain.address.model.Address
import com.redwork.domain.address.repository.AddressRepository
import com.redwork.domain.core.Resource
import com.redwork.infrastructure.address.repository.contacts.AddressTemporalRepository
import kotlinx.coroutines.flow.Flow

class AddressProxy(
    private val temporalRepository: AddressTemporalRepository
): AddressRepository {

    override fun getAddress(): Flow<Address?> = temporalRepository.getAddress()

    override suspend fun save(address: Address): Resource<Unit> = temporalRepository.save(address)

}
