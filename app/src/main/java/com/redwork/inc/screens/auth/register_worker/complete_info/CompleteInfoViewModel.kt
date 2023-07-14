package com.redwork.inc.screens.auth.register_worker.complete_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redwork.domain.category.model.Category
import com.redwork.domain.category.usecase.CategoryUseCase
import com.redwork.domain.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CompleteInfoViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : ViewModel() {

    var state by mutableStateOf(CompleteInfoState())
        private set

    fun getSelectedCategories() = viewModelScope.launch {
        categoryUseCase.getSelectedCategories().collect {
           state = state.copy(selectedCategories = it.toMutableList())
        }
    }

    fun onDescribeExperience(value: String) {
        state = state.copy(describeExperience = value)
    }

    fun onEmailInput(value: String) {
        state = state.copy(address = value)
    }

}