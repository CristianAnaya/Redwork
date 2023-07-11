package com.redwork.inc.di.auth

import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.auth.usecase.GetOTPUseCase
import com.redwork.domain.auth.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AuthDependencyInjection {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        getOTP = GetOTPUseCase(repository = authRepository),
        login = LoginUseCase(repository = authRepository)
    )

}