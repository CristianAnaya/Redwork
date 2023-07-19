package com.redwork.inc.screens.auth.register_worker.choose_address.dto

import com.redwork.inc.screens.auth.register_worker.choose_address.model.Prediction
import kotlinx.serialization.Serializable

@Serializable
data class PlacesDto(
    val predictions: List<Prediction> = listOf(),
    val status: String = ""
) {
    fun toPlacesList() = predictions.map { it.toPlace() }
}
