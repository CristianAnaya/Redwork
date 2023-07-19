package com.redwork.domain.address.usecase

data class AddressUseCase(
    val saveSelectedAddress: SaveSelectedAddressUseCase,
    val getAddress: GetAddressUseCase
)
