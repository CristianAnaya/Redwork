package com.redwork.infrastructure.address.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.redwork.domain.address.model.Address
import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R
import com.redwork.infrastructure.address.repository.contacts.AddressTemporalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class AddressDataStorePreferencesRepository(
    private val dataStore: DataStore<Preferences>
): AddressTemporalRepository {

    private val gson = Gson()
    private val selectedAddressKey = stringPreferencesKey("selected_address")

    override fun getAddress(): Flow<Address> {
        return dataStore.data
            .map { preferences ->
                val selectedAddressJson = preferences[selectedAddressKey]
                gson.fromJson(selectedAddressJson, object : TypeToken<Address>() {}.type)
            }
    }

    override suspend fun save(address: Address): Resource<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val selectedAddressJson = gson.toJson(address)
                dataStore.edit { preferences ->
                    preferences.remove(selectedAddressKey)
                    preferences[selectedAddressKey] = selectedAddressJson
                }
                Resource.Success(Unit)
            } catch (e: Exception) {
                Resource.Failure(UiText.StringResource(R.string.unexpected_error))
            }
        }
    }

}