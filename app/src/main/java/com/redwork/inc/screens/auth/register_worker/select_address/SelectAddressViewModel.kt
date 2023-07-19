package com.redwork.inc.screens.auth.register_worker.select_address

import android.location.Geocoder
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.maps.android.compose.CameraPositionState
import com.redwork.domain.address.usecase.AddressUseCase
import com.redwork.domain.core.Resource
import com.redwork.inc.screens.auth.register_worker.select_address.mapper.toAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectAddressViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
) : ViewModel() {

    var state by mutableStateOf(SelectAddressState())
        private set

    var saveSelectedAddressResource by mutableStateOf<Resource<Unit>?>(null)
        private set

    fun saveSelectedAddress() = viewModelScope.launch {
        saveSelectedAddressResource = Resource.Loading
        val result = addressUseCase.saveSelectedAddress(state.toAddress())
        saveSelectedAddressResource = result
    }

    private fun onAddressInput(value: String) {
        state = state.copy(address = value)
    }

    private fun onLatInput(value: Double) {
        state = state.copy(latitude = value)
    }

    private fun onLngInput(value: Double) {
        state = state.copy(longitude = value)
    }

    fun updateLocation(cameraPositionState: CameraPositionState, geocoder: Geocoder) {
        val location = cameraPositionState.position.target
        if (!cameraPositionState.isMoving) {
            if (location.latitude != 0.0 && location.longitude != 0.0) {
                onLatInput(location.latitude)
                onLngInput(location.longitude)
                val address = geocoder.getFromLocation(
                    location.latitude,
                    location.longitude, 1
                )?.get(0)?.getAddressLine(0)
                onAddressInput(address ?: "Seleccionar dirección")
            }
        }
    }

}