package com.redwork.inc.screens.auth.register_worker.complete_info

import androidx.lifecycle.ViewModel
import com.redwork.domain.category.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CompleteInfoViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : ViewModel() {



}