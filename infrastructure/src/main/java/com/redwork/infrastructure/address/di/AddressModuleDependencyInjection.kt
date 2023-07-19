package com.redwork.infrastructure.address.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.redwork.domain.address.repository.AddressRepository
import com.redwork.domain.category.repository.CategoryRepository
import com.redwork.infrastructure.address.repository.AddressDataStorePreferencesRepository
import com.redwork.infrastructure.address.repository.AddressProxy
import com.redwork.infrastructure.address.repository.contacts.AddressTemporalRepository
import com.redwork.infrastructure.category.repository.CategoryDataStorePreferencesRepository
import com.redwork.infrastructure.category.repository.CategoryProxy
import com.redwork.infrastructure.category.repository.contracts.CategoryRemoteRepository
import com.redwork.infrastructure.category.repository.contracts.CategoryTemporalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AddressModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideAddressTemporalRepository(
        dataStore: DataStore<Preferences>
    ): AddressTemporalRepository = AddressDataStorePreferencesRepository(dataStore)

    @Provides
    fun provideAddressRepository(
        temporalRepository: AddressTemporalRepository
    ): AddressRepository = AddressProxy(
        temporalRepository = temporalRepository
    )

}