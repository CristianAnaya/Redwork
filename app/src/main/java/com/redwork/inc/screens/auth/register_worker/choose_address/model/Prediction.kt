package com.redwork.inc.screens.auth.register_worker.choose_address.model

import kotlinx.serialization.Serializable


@Serializable
data class Prediction(
    val description: String = "",
    val place_id: String = "",
    val reference: String = "",
    val types: List<String> = listOf()
) {
    fun toPlace() = Place(
        id = place_id,
        name = description
    )
}