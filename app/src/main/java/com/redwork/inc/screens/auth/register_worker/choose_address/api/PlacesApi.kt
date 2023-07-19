package com.redwork.inc.screens.auth.register_worker.choose_address.api

import android.content.Context
import android.util.Log
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.redwork.inc.screens.auth.register_worker.choose_address.dto.PlacesDto
import com.redwork.inc.screens.auth.register_worker.choose_address.model.Place
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.URLProtocol
import kotlinx.serialization.decodeFromString
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PlacesApi {
    private val client: HttpClient = HttpClient {
        install(Logging) {
            level = LogLevel.HEADERS
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "PlacesApi", message = message)
                }
            }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }

    private val json = Json { ignoreUnknownKeys = true }

    suspend fun fetchPlaces(
        key: String,
        input: String
    ): List<Place> {
        val response = client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "maps.googleapis.com"
                path("maps/api/place/autocomplete/json")

                parameters.append("key", key)
                parameters.append("types", "address")
                parameters.append("input", input)
            }
        }

        // This converts our JSON to a PlacesDto object
        val placesDto = json.decodeFromString<PlacesDto>(response.bodyAsText())
        // We return the places list



        return placesDto.toPlacesList()
    }
}

private suspend fun getPlaceDetails(placeId: String, context: Context): com.google.android.libraries.places.api.model.Place {
    val placeFields = listOf(
        com.google.android.libraries.places.api.model.Place.Field.ID,
        com.google.android.libraries.places.api.model.Place.Field.ADDRESS,
        com.google.android.libraries.places.api.model.Place.Field.LAT_LNG,
        com.google.android.libraries.places.api.model.Place.Field.NAME
    )
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