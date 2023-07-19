package com.redwork.inc.screens.auth.register_worker.select_address.components

import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.redwork.inc.R
import android.Manifest
import android.location.Geocoder
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.android.libraries.places.api.model.Place
import com.redwork.inc.components.DefaultButton
import com.redwork.inc.components.location.getLastLocation
import com.redwork.inc.navigation.screen.auth.AuthScreen
import com.redwork.inc.screens.auth.register_worker.select_address.SelectAddressViewModel
import com.redwork.inc.ui.theme.white20Bold


private const val LOCATION_PERMISSION_REQUEST_CODE = 123

@Composable
fun SelectAddressContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: SelectAddressViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val geocoder = Geocoder(context)

    val fusedLocationProviderClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val currentLocation = remember { mutableStateOf<Location?>(null) }

    val cameraPositionState = rememberCameraPositionState()

    val place = remember {
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<Place>("selectedPlace")
    }

    val locationPermission = Manifest.permission.ACCESS_FINE_LOCATION
    val permissionGranted = ActivityCompat.checkSelfPermission(context, locationPermission) == PackageManager.PERMISSION_GRANTED

    LaunchedEffect(Unit) {
        if (permissionGranted) {
            try {
                val location = getLastLocation(context, fusedLocationProviderClient)
                place?.value?.let { selectedPlace ->
                    selectedPlace.latLng?.let {
                        val placeLatLng = LatLng(it.latitude, it.longitude)
                        cameraPositionState.position = CameraPosition.fromLatLngZoom(placeLatLng, 18f)
                    }
                } ?: location?.let {
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(
                        LatLng(it.latitude, it.longitude),
                        18f
                    )
                }
            } catch (e: Exception) {
                // Handle location retrieval error
            }
        } else {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(locationPermission),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        viewModel.updateLocation(cameraPositionState, geocoder)

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = "marker",
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(route = AuthScreen.ChooseAddress.route) }
                .padding(16.dp)
                .align(Alignment.TopStart),
            value = viewModel.state.address,
            enabled = false,
            onValueChange = {},
            placeholder = { Text("Buscar tu dirección") }
        )

        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            text = stringResource(id = R.string.save_information),
            style = white20Bold,
            roundedCornerValue = 50,
            onClick = {
                viewModel.saveSelectedAddress()
            }
        )
    }

}



//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 15.dp, vertical = 10.dp)
//                .clickable { navController.navigate(route = AuthScreen.ChooseAddress.route) },
//            contentAlignment = Alignment.Center
//        ) {
//            TextField(
//                value = state.address,
//                onValueChange = { },
//                placeholder = {
//                    Text(text = "Pickup Location")
//                },
//                colors = TextFieldDefaults.textFieldColors(
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                ),
//                shape = RoundedCornerShape(5.dp),
//                modifier = Modifier.fillMaxWidth(0.9f)
//            )
//        }