package com.redwork.domain.auth.usecase

data class AuthUseCase(
    val getOTP: GetOTPUseCase,
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveInfoToWorker: SaveInfoToWorkerUseCase,
    val getSession: GetSessionUseCase,
    val saveFirstTime: SaveFirstTimeUseCase,
    val getFirstTime: GetFirstTimeUseCase
)
