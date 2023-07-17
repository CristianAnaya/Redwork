package com.redwork.inc.components.google_services

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.google.android.gms.tasks.TaskCompletionSource
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@Composable
fun AutocompleteTextField(
    modifier: Modifier = Modifier,
    apiKey: String,
    onPlaceSelected: (Place) -> Unit
) {
    val context = LocalContext.current

    val placesClient = remember { Places.createClient(context) }
    val suggestions = remember { mutableStateListOf<PlaceSuggestion>() }
    val selectedPlace = remember { mutableStateOf<PlaceSuggestion?>(null) }

    TextField(
        modifier = modifier,
        value = selectedPlace.value?.description ?: "",
        onValueChange = {},
        placeholder = { Text(text = "Search address") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
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
        modifier = Modifier.wrapContentHeight(),
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

    LaunchedEffect(Unit) {
        val token = AutocompleteSessionToken.newInstance()
        val request = FindAutocompletePredictionsRequest.builder()
            .setTypeFilter(TypeFilter.ADDRESS)
            .setSessionToken(token)
            .setQuery(selectedPlace.value?.description ?: "")
            .build()

        placesClient.findAutocompletePredictions(request).addOnSuccessListener { response ->
            val newSuggestions = response.autocompletePredictions.map { prediction ->
                PlaceSuggestion(prediction.placeId, prediction.getFullText(null).toString(), prediction)
            }
            suggestions.clear()
            suggestions.addAll(newSuggestions)
        }
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



