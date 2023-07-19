package com.redwork.infrastructure.auth.httpclient.dto

import com.google.gson.annotations.SerializedName
import com.redwork.domain.category.model.Category
import java.io.Serializable

data class RegisterInfoDto(
    @SerializedName("describe_experience") val describeExperience: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    @SerializedName("selected_categories") val selectedCategories: List<Category>
): Serializable
