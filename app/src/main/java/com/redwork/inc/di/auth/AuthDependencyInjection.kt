package com.redwork.inc.di.auth

import com.redwork.domain.auth.repository.AuthRepository
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.auth.usecase.GetFirstTimeUseCase
import com.redwork.domain.auth.usecase.GetOTPUseCase
import com.redwork.domain.auth.usecase.GetSessionUseCase
import com.redwork.domain.auth.usecase.LoginUseCase
import com.redwork.domain.auth.usecase.RegisterUseCase
import com.redwork.domain.auth.usecase.SaveFirstTimeUseCase
import com.redwork.domain.auth.usecase.SaveInfoToWorkerUseCase
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
        login = LoginUseCase(repository = authRepository),
        register = RegisterUseCase(repository = authRepository),
        saveInfoToWorker = SaveInfoToWorkerUseCase(repository = authRepository),
        getSession = GetSessionUseCase(repository = authRepository),
        saveFirstTime = SaveFirstTimeUseCase(repository = authRepository),
        getFirstTime = GetFirstTimeUseCase(repository = authRepository)
    )

}