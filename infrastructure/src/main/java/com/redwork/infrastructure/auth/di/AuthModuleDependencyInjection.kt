package com.redwork.infrastructure.auth.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.infrastructure.auth.httpclient.service.AuthService
import com.redwork.infrastructure.auth.repository.AuthDataStorePreferencesRepository
import com.redwork.infrastructure.auth.repository.AuthFirebaseRepository
import com.redwork.infrastructure.auth.repository.AuthProxy
import com.redwork.infrastructure.auth.repository.AuthRetrofitRepository
import com.redwork.infrastructure.auth.repository.contracts.AuthDataSourceRepository
import com.redwork.infrastructure.auth.repository.contracts.AuthRemoteRepository
import com.redwork.infrastructure.auth.repository.contracts.AuthTemporalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    fun provideAuthRemoteRepository(
        authService: AuthService
    ): AuthRemoteRepository = AuthRetrofitRepository(authService = authService)

    @Provides
    fun provideAuthDataSourceRepository(): AuthDataSourceRepository = AuthFirebaseRepository()

    @Provides
    @Singleton
    fun provideAuthTemporalRepository(
        dataStore: DataStore<Preferences>
    ): AuthTemporalRepository = AuthDataStorePreferencesRepository(dataStore)

    @Provides
    fun provideAuthRepository(
        dataSourceRepository: AuthDataSourceRepository,
        remoteRepository: AuthRemoteRepository,
        temporalRepository: AuthTemporalRepository
    ): AuthRepository = AuthProxy(
        dataSourceRepository = dataSourceRepository,
        remoteRepository = remoteRepository,
        temporalRepository = temporalRepository
    )

}