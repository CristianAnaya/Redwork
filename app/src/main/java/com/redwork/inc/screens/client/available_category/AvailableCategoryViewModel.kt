package com.redwork.inc.screens.client.available_category

import android.util.Log
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
class AvailableCategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
): ViewModel() {

    var categoriesResource by mutableStateOf<Resource<List<Category>>?>(null)
        private set

    fun getCategories() = viewModelScope.launch {
        categoriesResource = Resource.Loading
        categoryUseCase.findAll().collect {
            Log.d("AvailableCategoryViewModel", "getCategories: ${it}")
            categoriesResource = it
        }
    }
}