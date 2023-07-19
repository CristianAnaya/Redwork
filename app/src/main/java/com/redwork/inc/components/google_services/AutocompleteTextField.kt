package com.redwork.inc.components.google_services

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.tasks.TaskCompletionSource
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.redwork.inc.screens.auth.register_worker.select_address.SelectAddressViewModel
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AutocompleteTextField(
    modifier: Modifier = Modifier,
    apiKey: String,
    onPlaceSelected: (Place) -> Unit,
    viewModel: SelectAddressViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(apiKey) {
        Places.initialize(context, apiKey)
    }

    val placesClient = remember { Places.createClient(context) }
    val suggestions = remember { mutableStateListOf<PlaceSuggestion>() }
    val selectedPlace = remember { mutableStateOf<PlaceSuggestion?>(null) }
    val searchText = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val dropdownHeight = remember { mutableIntStateOf(0) }

    val softwareKeyboardController = LocalSoftwareKeyboardController.current


    Column {
        BoxWithConstraints(modifier.fillMaxWidth()) {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .onFocusEvent { focusState ->
                        if (focusState.isFocused) {
                        }
                    }
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            softwareKeyboardController?.show()
                        }
                    },
                value = viewModel.state.address,
                onValueChange = { text ->
                    //viewModel.onAddressInput(text)
                    fetchAutocompletePredictions(placesClient, text, suggestions)
                },
                placeholder = { Text(text = "Search address") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions(
                    onDone = {
                        selectedPlace.value?.let { suggestion ->
                            val placeId = suggestion.placeId
                            val place = runBlocking { getPlaceDetails(placeId, context) }
                            onPlaceSelected(place)
                        }
                    }
                )
            )

            DropdownMenu(
                modifier = Modifier
                    .wrapContentSize()
                    .width(with(LocalDensity.current) { constraints.maxWidth.toDp() })
                    .height(IntrinsicSize.Min),
                expanded = suggestions.isNotEmpty(),
                onDismissRequest = { suggestions.clear() }
            ) {
                suggestions.forEach { suggestion ->
                    DropdownMenuItem(onClick = {
                        selectedPlace.value = suggestion
                        suggestions.clear()
                    }) {
                        Text(text = suggestion.description)
                    }
                }
            }
        }
    }

}

private fun fetchAutocompletePredictions(
    placesClient: PlacesClient,
    query: String,
    suggestions: MutableList<PlaceSuggestion>
) {
    val token = AutocompleteSessionToken.newInstance()
    val request = FindAutocompletePredictionsRequest.builder()
        .setTypeFilter(TypeFilter.ADDRESS)
        .setSessionToken(token)
        .setQuery(query)
        .build()

    placesClient.findAutocompletePredictions(request).addOnSuccessListener { response ->
        val newSuggestions = response.autocompletePredictions.map { prediction ->
            PlaceSuggestion(prediction.placeId, prediction.getFullText(null).toString(), prediction)
        }
        suggestions.clear()
        suggestions.addAll(newSuggestions)
    }
}

data class PlaceSuggestion(
    val placeId: String,
    val description: String,
    val prediction: AutocompletePrediction
)

private suspend fun getPlaceDetails(placeId: String, context: Context): Place {
    val placeFields = listOf(Place.Field.LAT_LNG)
    val request = FetchPlaceRequest.builder(placeId, placeFields).build()

    return suspendCoroutine { continuation ->
        Places.createClient(context).fetchPlace(request).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val response = task.result
                val place = response.place
                continuation.resume(place)
            } else {
                val exception = task.exception
                continuation.resumeWithException(exception ?: Exception("Failed to fetch place details"))
            }
        }
    }
}



