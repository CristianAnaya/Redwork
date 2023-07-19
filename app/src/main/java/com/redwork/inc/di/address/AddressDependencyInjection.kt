package com.redwork.inc.di.address

import com.redwork.domain.address.repository.AddressRepository
import com.redwork.domain.address.usecase.AddressUseCase
import com.redwork.domain.address.usecase.GetAddressUseCase
import com.redwork.domain.address.usecase.SaveSelectedAddressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AddressDependencyInjection {

    @Provides
    fun provideAddressUseCase(addressRepository: AddressRepository) = AddressUseCase(
        saveSelectedAddress = SaveSelectedAddressUseCase(repository = addressRepository),
        getAddress = GetAddressUseCase(repository = addressRepository)
    )

}