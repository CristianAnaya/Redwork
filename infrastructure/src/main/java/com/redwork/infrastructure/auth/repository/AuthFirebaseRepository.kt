package com.redwork.infrastructure.auth.repository

import android.app.Activity
import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R.string.failed_get_otp
import com.redwork.infrastructure.R.string.invalid_verification_code
import com.redwork.infrastructure.R.string.there_is_not_network_connection
import com.redwork.infrastructure.R.string.unexpected_error_login
import com.redwork.infrastructure.R.string.wrong_phone_number
import com.redwork.infrastructure.auth.repository.contracts.AuthDataSourceRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.util.concurrent.TimeUnit

class AuthFirebaseRepository: AuthDataSourceRepository {

    companion object {
        private val fAuth = FirebaseAuth.getInstance()

    }

    override fun getOTP(phone: String, country: String, context: Activity): Flow<Resource<String>> = callbackFlow {
        try {

            fAuth.firebaseAuthSettings.setAppVerificationDisabledForTesting(true);

            val options = PhoneAuthOptions.newBuilder(fAuth)
                .setPhoneNumber("+57$phone")
                .setActivity(context)
                .setTimeout(10L, TimeUnit.SECONDS)
                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onCodeSent(
                        verificationId: String,
                        token: PhoneAuthProvider.ForceResendingToken
                    ) {
                        if (verificationId.isNotEmpty())
                            trySend(Resource.Success(verificationId))
                        else
                            trySend(Resource.Failure(UiText.StringResource(failed_get_otp)))

                        close()
                    }

                    override fun onCodeAutoRetrievalTimeOut(verificationId: String) {
                    }

                    override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                    }

                    override fun onVerificationFailed(exception: FirebaseException) {
                        Log.d("TAG", "onVerificationFailed: ${exception.message}")
                        trySend(Resource.Failure(UiText.StringResource(failed_get_otp)))
                        close()
                    }
                })
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)

            awaitClose { this.cancel() }

        } catch (e: Exception) {
            trySend(Resource.Failure(UiText.StringResource(there_is_not_network_connection)))
            close()
        }
    }

    override fun loginWithOTP(
        phone: String,
        code: String,
        verificationId: String
    ): Flow<Resource<String>> = callbackFlow {
        try {
            val credential = PhoneAuthProvider.getCredential(verificationId, code)
            fAuth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        trySend(Resource.Success(phone))
                    } else {
                        val error = when (task.exception) {
                            is FirebaseAuthInvalidCredentialsException -> {
                                UiText.StringResource(invalid_verification_code)
                            }
                            is FirebaseAuthInvalidUserException -> {
                                UiText.StringResource(wrong_phone_number)
                            }
                            else -> {
                                UiText.StringResource(unexpected_error_login)
                            }
                        }
                        trySend(Resource.Failure(error))
                    }
                    close()
                }
        } catch (e: Exception) {
            Log.d("TAG", "loginWithOTP: ${e.message}")
            trySend(Resource.Failure(UiText.StringResource(there_is_not_network_connection)))
            close()
        }
        awaitClose { this.cancel() }
    }

}