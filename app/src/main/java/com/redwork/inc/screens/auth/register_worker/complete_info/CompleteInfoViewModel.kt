package com.redwork.inc.screens.auth.register_worker.complete_info

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redwork.domain.address.usecase.AddressUseCase
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.auth.usecase.AuthUseCase
import com.redwork.domain.category.model.Category
import com.redwork.domain.category.usecase.CategoryUseCase
import com.redwork.domain.core.Resource
import com.redwork.inc.screens.auth.register_worker.complete_info.mapper.toRegisterInfo
import com.redwork.inc.screens.auth.register_worker.info_base.mapper.toRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CompleteInfoViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var state by mutableStateOf(CompleteInfoState())
        private set

    var registerInfoResource by mutableStateOf<Resource<Auth>?>(null)
        private set

    fun getSelectedCategories() = viewModelScope.launch {
        categoryUseCase.getSelectedCategories().collect {
           state = state.copy(selectedCategories = it.toMutableList())
        }
    }

    fun saveInfo() = viewModelScope.launch {
        registerInfoResource = Resource.Loading
        val result = authUseCase.saveInfoToWorker(state.idUser, state.toRegisterInfo())
        registerInfoResource = result
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSession().collect { data ->
            state = state.copy(idUser = data.user?.id ?: "", name = "${data.user?.name} ${data.user?.lastname}")
        }
    }

    fun getSelectedAddress() = viewModelScope.launch {
        addressUseCase.getAddress().collect {
            state = state.copy(address = it.address, latitude = it.latitude, longitude = it.longitude)
        }
    }

    fun onDescribeExperience(value: String) {
        state = state.copy(describeExperience = value)
    }

}