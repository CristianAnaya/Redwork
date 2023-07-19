package com.redwork.inc.screens.auth.register_worker.complete_info.mapper

import com.redwork.domain.auth.model.RegisterInfo
import com.redwork.inc.screens.auth.register_worker.complete_info.CompleteInfoState

fun CompleteInfoState.toRegisterInfo(): RegisterInfo {
    return RegisterInfo(
        describeExperience = describeExperience,
        address = address,
        latitude = latitude,
        longitude = longitude,
        selectedCategories = selectedCategories
    )
}