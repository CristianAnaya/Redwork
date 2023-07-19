package com.redwork.domain.address.usecase

import com.redwork.domain.address.model.Address
import com.redwork.domain.address.repository.AddressRepository
import com.redwork.domain.core.Resource

class SaveSelectedAddressUseCase(private val repository: AddressRepository) {
    suspend operator fun invoke(address: Address): Resource<Unit> = repository.save(address)
}