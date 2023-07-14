package com.redwork.inc.screens.auth.register_worker.selected_category

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redwork.domain.auth.model.Auth
import com.redwork.domain.category.model.Category
import com.redwork.domain.category.usecase.CategoryUseCase
import com.redwork.domain.core.Resource
import com.redwork.inc.screens.auth.register_worker.info_base.mapper.toRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectedCategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
): ViewModel() {

    var categoriesResource by mutableStateOf<Resource<List<Category>>?>(null)
        private set

    var saveSelectedCategoriesResource by mutableStateOf<Resource<Unit>?>(null)
        private set

    fun getCategories() = viewModelScope.launch {
        categoriesResource = Resource.Loading
        categoryUseCase.findAllWithService().collect {
            categoriesResource = it
        }
    }

    fun saveSelectedCategories(selectedCategories: List<Category>) = viewModelScope.launch {
        saveSelectedCategoriesResource = Resource.Loading
        val result = categoryUseCase.saveSelectedCategories(selectedCategories)
        saveSelectedCategoriesResource = result
    }

}