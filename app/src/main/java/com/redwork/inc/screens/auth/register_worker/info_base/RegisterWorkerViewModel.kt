package com.redwork.inc.screens.auth.register_worker.info_base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.core.Resource
import com.redwork.inc.screens.auth.register_worker.info_base.mapper.toRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterWorkerViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private var role = savedStateHandle.get<String>("role")
    private var phone = savedStateHandle.get<String>("phone")

    var state by mutableStateOf(RegisterWorkerState())
        private set

    var registerResource by mutableStateOf<Resource<Auth>?>(null)

    init {
        state.role.add(role ?: "")
        state = state.copy(phone = phone ?: "")
    }

    fun register() = viewModelScope.launch {
        registerResource = Resource.Loading
        val result = authUseCase.register(state.toRegister())
        registerResource = result
    }

    fun onNameInput(value: String) {
        state = state.copy(name = value)
    }

    fun onLastnameInput(value: String) {
        state = state.copy(lastname = value)
    }

    fun onEmailInput(value: String) {
        state = state.copy(email = value)
    }

}