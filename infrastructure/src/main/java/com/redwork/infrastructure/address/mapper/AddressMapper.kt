package com.redwork.infrastructure.address.mapper

import com.redwork.domain.address.model.Address
import com.redwork.infrastructure.address.httpclient.dto.AddressDto

fun Address.toAddressDto(): AddressDto {
    return AddressDto(
        address,
        latitude,
        longitude
    )
}

fun AddressDto.toAddress(): Address {
    return Address(
        address,
        latitude,
        longitude
    )
}