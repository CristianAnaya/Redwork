package com.redwork.infrastructure.auth.di

import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.infrastructure.auth.network.service.AuthService
import com.redwork.infrastructure.auth.repository.AuthFirebaseRepository
import com.redwork.infrastructure.auth.repository.AuthProxy
import com.redwork.infrastructure.auth.repository.contracts.AuthDataSourceRepository
import com.redwork.infrastructure.auth.repository.contracts.AuthRemoteRepository
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
        authFirebaseRepository: AuthFirebaseRepository
    ): AuthDataSourceRepository = AuthFirebaseRepository()

    @Provides
    fun provideAuthRepository(
        dataSourceRepository: AuthDataSourceRepository,
        remoteRepository: AuthRemoteRepository
    ): AuthRepository = AuthProxy(
        dataSourceRepository = dataSourceRepository,
        remoteRepository = remoteRepository
    )

}