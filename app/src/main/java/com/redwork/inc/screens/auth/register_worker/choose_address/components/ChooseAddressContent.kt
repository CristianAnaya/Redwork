package com.redwork.inc.screens.auth.register_worker.choose_address.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.redwork.inc.screens.auth.register_worker.choose_address.ChooseAddressViewModel
import com.redwork.inc.ui.theme.black15Medium
import com.redwork.inc.ui.theme.lightGray15

@Composable
fun ChooseAddressContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: ChooseAddressViewModel = hiltViewModel()
) {

    val pickupLocationPlaces by viewModel.pickupLocationPlaces.collectAsStateWithLifecycle()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            shadowElevation = 5.dp,
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    value = viewModel.pickUp,
                    textStyle = black15Medium,
                    onValueChange = viewModel::onPickUpValueChanged,
                    placeholder = {
                        Text(
                            text = "Buscar tu dirección",
                            style = black15Medium
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
            }
        }
        LazyColumn {
            items(pickupLocationPlaces) { place ->
                ListItem(
                    headlineText = {
                        Text(
                            text = place.name,
                            style = black15Medium
                        )
                    },
                    modifier = Modifier.clickable {
                        getPlaceDetails(place.id, context, navController)
                    }
                )
            }
        }
    }
}

private fun getPlaceDetails(placeId: String, context: Context, navController: NavHostController) {
    val placeFields = listOf(com.google.android.libraries.places.api.model.Place.Field.LAT_LNG)
    val request = FetchPlaceRequest.builder(placeId, placeFields).build()

    Places.createClient(context).fetchPlace(request).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val response = task.result
            val place = response.place
            navController.previousBackStackEntry?.savedStateHandle?.set("selectedPlace", place)
            navController.popBackStack()
        }
    }
}