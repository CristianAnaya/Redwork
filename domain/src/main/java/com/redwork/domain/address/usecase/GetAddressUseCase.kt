package com.redwork.domain.address.usecase

import com.redwork.domain.address.repository.AddressRepository

class GetAddressUseCase(private val repository: AddressRepository) {
    operator fun invoke() = repository.getAddress()
}