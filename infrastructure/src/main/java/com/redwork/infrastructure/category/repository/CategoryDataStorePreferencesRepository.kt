package com.redwork.infrastructure.category.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.redwork.domain.category.model.Category
import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R
import com.redwork.infrastructure.category.repository.contracts.CategoryTemporalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CategoryDataStorePreferencesRepository(
    private val dataStore: DataStore<Preferences>
): CategoryTemporalRepository {

    private val gson = Gson()
    private val selectedCategoriesKey = stringPreferencesKey("selected_categories")


    override fun getSelectedCategories(): Flow<List<Category>> {
        return dataStore.data
            .map { preferences ->
                val selectedCategoriesJson = preferences[selectedCategoriesKey]
                if (selectedCategoriesJson.isNullOrEmpty()) {
                    emptyList()
                } else {
                    gson.fromJson(selectedCategoriesJson, object : TypeToken<List<Category>>() {}.type)
                }
            }
    }

    override suspend fun saveSelectedCategories(categories: List<Category>): Resource<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val selectedCategoriesJson = gson.toJson(categories)
                dataStore.edit { preferences ->
                    preferences.remove(selectedCategoriesKey)
                    preferences[selectedCategoriesKey] = selectedCategoriesJson
                }
                Resource.Success(Unit)
            } catch (e: Exception) {
                Resource.Failure(UiText.StringResource(R.string.unexpected_error))
            }
        }
    }
}