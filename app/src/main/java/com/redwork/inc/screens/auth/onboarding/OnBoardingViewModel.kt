package com.redwork.inc.screens.auth.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {


    var saveFirstTimeResource by mutableStateOf<Resource<Unit>?>(null)
        private set

    fun saveFirstTime() = viewModelScope.launch {
        authUseCase.saveFirstTime.invoke(false)
        saveFirstTimeResource = Resource.Success(Unit)
    }
}
