package com.redwork.inc.screens.auth.login.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.redwork.inc.R
import com.redwork.inc.components.CircularResourceImage
import com.redwork.inc.components.SizedBox
import com.redwork.inc.ui.theme.black15
import com.redwork.inc.ui.theme.gray20Bold
import io.github.farhanroy.cccp.CCPCountry
import io.github.farhanroy.cccp.getFlagMasterResID
import io.github.farhanroy.cccp.getLibraryMasterCountriesEnglish


@Composable
fun CountryCodePicker(pickedCountry: (CCPCountry) -> Unit) {
    val countryList: List<CCPCountry> = getLibraryMasterCountriesEnglish()
    val picked = remember { mutableStateOf(countryList[0]) }
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false) }
            val dialogWidth = 250.dp
            val dialogHeight = 400.dp

            Row(
                Modifier.clickable { openDialog.value = true },
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularResourceImage(
                    resourceId = getFlagMasterResID(picked.value),
                    size = 30
                )
                SizedBox(
                    width = 5
                )
                Icon(
                    Icons.Filled.ArrowDropDown,
                    contentDescription = stringResource(id = R.string.image_description),
                    modifier = Modifier.size(15.dp),
                    tint = Color.Gray
                )
                Text(
                    "+${picked.value.phoneCode}",
                    style = gray20Bold
                )
            }

            if (openDialog.value) {
                Dialog(onDismissRequest = { openDialog.value = false }) {
                    Box(
                        Modifier
                            .size(dialogWidth, dialogHeight)
                            .background(Color.White)
                    ) {
                        LazyColumn {
                            items(countryList.size) { index ->
                                Row(
                                    Modifier
                                        .padding(
                                            horizontal = 18.dp,
                                            vertical = 18.dp
                                        )
                                        .clickable {
                                            pickedCountry(countryList[index])
                                            picked.value = countryList[index]
                                            openDialog.value = false
                                        }) {
                                    CircularResourceImage(
                                        resourceId = getFlagMasterResID(countryList[index]),
                                        size = 30
                                    )
                                    Text(
                                        countryList[index].name,
                                        style = black15,
                                        modifier = Modifier.padding(horizontal = 18.dp)
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }

    }
}


