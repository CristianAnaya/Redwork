package com.redwork.inc.screens.auth.register_worker.selected_category.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redwork.domain.category.model.Category
import com.redwork.domain.service.model.Service
import com.redwork.inc.R
import com.redwork.inc.R.string.save_information
import com.redwork.inc.components.DefaultButton
import com.redwork.inc.screens.auth.register_worker.selected_category.SelectedCategoryViewModel
import com.redwork.inc.ui.theme.Orange
import com.redwork.inc.ui.theme.black13Medium
import com.redwork.inc.ui.theme.white20Bold

@Composable
fun SelectedCategoryContent(
    paddingValues: PaddingValues,
    categories: List<Category>,
    viewModel: SelectedCategoryViewModel = hiltViewModel()
) {
    //val selectedCategories = remember { mutableStateListOf<Category>() }
    val selectedServices = remember { mutableStateMapOf<Service, Boolean>() }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            categories.forEachIndexed { index, category ->
                var isExpanded by remember { mutableStateOf(false) }

                if (index > 0) {
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isExpanded = !isExpanded },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = category.name,
                        modifier = Modifier.weight(1f),
                        style = black13Medium
                    )
                    IconButton(
                        onClick = { isExpanded = !isExpanded }
                    ) {
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand/Collapse"
                        )
                    }
                }

                if (isExpanded) {
                    category.services?.forEach { service ->
                        //val isSelected = remember { mutableStateOf(service.isSelected) }
                        val isSelected = selectedServices.getOrElse(service) { false }

                        Row(
                            modifier = Modifier.padding(start = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = service.name,
                                modifier = Modifier.weight(1f),
                                style = black13Medium
                            )
                            Switch(
                                checked = isSelected,
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Orange,
                                    checkedTrackColor = Color(0xFFFFCCBC)
                                ),
                                onCheckedChange = { newValue ->
                                   // isSelected.value = newValue
                                    selectedServices[service] = newValue
                                }
                            )
                        }
                    }
                }
            }
        }

        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = stringResource(id = save_information),
            style = white20Bold,
            roundedCornerValue = 50,
            onClick = {
                val selectedCategories = categories.mapNotNull { category ->
                    val selectedServicesForCategory = category.services?.filter { service ->
                        selectedServices[service] == true
                    }?.map { selectedService ->
                        selectedService.copy(isSelected = true)
                    }

                    if (selectedServicesForCategory?.isNotEmpty()!!) {
                        category.copy(services = selectedServicesForCategory)
                    } else {
                        null
                    }
                }

                viewModel.saveSelectedCategories(selectedCategories)
            }
        )
    }
}

