package com.redwork.infrastructure.auth.repository

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.model.User
import com.redwork.infrastructure.auth.mapper.toAuth
import com.redwork.infrastructure.auth.mapper.toAuthDto
import com.redwork.infrastructure.auth.network.dto.AuthDto
import com.redwork.infrastructure.auth.repository.contracts.AuthTemporalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class AuthDataStorePreferencesRepository (
    private val dataStore: DataStore<Preferences>
): AuthTemporalRepository {

    companion object {
        private const val AUTH_KEY = "AUTH_KEY"
        private const val FIRST_KEY = "FIRST_TIME"
    }

    override suspend fun saveSession(auth: Auth) {
        val authDto = auth.toAuthDto()
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authDto.toJson()
        }
    }

    override suspend fun fistTime(status: Boolean) {
        val dataStoreKey = booleanPreferencesKey(FIRST_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = status
        }
    }

    override fun getSessionData(): Flow<Auth> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                AuthDto.fromJson(pref[dataStoreKey] ?: "").toAuth()
            } else {
                AuthDto().toAuth()
            }
        }
    }

    override suspend fun getFirstTime(): Boolean {
        val dataStoreKey = booleanPreferencesKey(FIRST_KEY)
        return dataStore.data.map {
            if (it[dataStoreKey] != null) {
                return@map it[dataStoreKey] ?: false
            } else {
                return@map true
            }
        }.first()
    }

    override suspend fun updateSessionData(user: User) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        val auth = runBlocking { getSessionData().first() }
        auth.user?.name = user.name
        auth.user?.lastname = user.lastname
        auth.user?.phone = user.phone
        if (!user.image.isNullOrBlank()) auth.user?.image = user.image

        dataStore.edit { pref ->
            pref[dataStoreKey] = auth.toAuthDto().toJson()
        }
    }

    override suspend fun logout() {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref.remove(dataStoreKey)
        }
    }

}