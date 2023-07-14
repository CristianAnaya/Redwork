package com.redwork.inc.screens.auth.register_worker.complete_info

import com.redwork.domain.category.model.Category

data class CompleteInfoState(
    val describeExperience: String = "",
    val address: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val phone: String = "",
    val selectedCategories: List<Category> = listOf()
)