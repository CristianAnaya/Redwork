package com.redwork.inc.screens.auth.register_worker.choose_address

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.redwork.inc.R
import com.redwork.inc.screens.auth.register_worker.choose_address.api.PlacesApi
import com.redwork.inc.screens.auth.register_worker.choose_address.model.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class ChooseAddressViewModel @Inject constructor() : ViewModel() {

    var pickUp by mutableStateOf(TextFieldValue(text = ""))
        private set

    private val placesApi = PlacesApi()

    // This will fetch places every time pickUp is changed and return them as state
    @OptIn(ExperimentalCoroutinesApi::class)
    val pickupLocationPlaces: StateFlow<List<Place>> =
        snapshotFlow { pickUp }
            .mapLatest {
                placesApi.fetchPlaces(
                    key = "AIzaSyCSD0C3bcDvBqfyoOW-gcCJ7M0gU2G1GTE",
                    input = pickUp.text
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun onPickUpValueChanged(value: TextFieldValue) {
        pickUp = value
    }

    fun onPlaceClick(value: String) {
        pickUp = TextFieldValue(
            text = value,
            selection = TextRange(value.length)
        )
    }


//        return suspendCoroutine { continuation ->
//            Places.createClient(context).fetchPlace(request).addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val response = task.result
//                    val place = response.place
//                    continuation.resume(place)
//                } else {
//                    val exception = task.exception
//                    continuation.resumeWithException(exception ?: Exception("Failed to fetch place details"))
//                }
//            }
//        }

}