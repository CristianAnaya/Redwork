package com.redwork.domain.address.repository

import com.redwork.domain.address.model.Address
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    fun getLocationOne(): Flow<Result<Address>>
}