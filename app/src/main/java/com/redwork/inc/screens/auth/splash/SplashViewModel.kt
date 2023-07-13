package com.redwork.inc.screens.auth.splash

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var sessionResource by mutableStateOf<Resource<Auth>?>(null)
        private set

    private val _isFirstTime = MutableStateFlow<Boolean?>(null)
    val isFirstTime: StateFlow<Boolean?> = _isFirstTime.asStateFlow()

    init {
        getFirstTime()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSession().collect { data ->
            sessionResource = Resource.Success(data)
        }
    }

    private fun getFirstTime() = viewModelScope.launch {
        Log.d("SplashViewModel", "getFirstTime: 1")
        val isFirstTime = authUseCase.getFirstTime.invoke()
        Log.d("SplashViewModel", "getFirstTime: 2 $isFirstTime")
        _isFirstTime.value = isFirstTime
    }
}