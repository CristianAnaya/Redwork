package com.redwork.domain.auth.model

import com.redwork.domain.category.model.Category

data class RegisterInfo(
    val describeExperience: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val selectedCategories: List<Category>
)
