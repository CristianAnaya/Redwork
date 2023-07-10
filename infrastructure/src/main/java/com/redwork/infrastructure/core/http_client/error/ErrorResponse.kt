package com.redwork.infrastructure.core.http_client.error

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val statusCode: Int = 500,
    val message: String = ""
)
