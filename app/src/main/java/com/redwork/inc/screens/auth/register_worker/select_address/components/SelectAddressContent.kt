package com.redwork.inc.screens.auth.register_worker.select_address.components

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.redwork.inc.R
import android.Manifest
import androidx.compose.runtime.LaunchedEffect
import com.redwork.inc.components.GoogleMapView
import com.redwork.inc.components.location.getLastLocation
import com.redwork.inc.screens.auth.register_worker.select_address.SelectAddressViewModel


private const val LOCATION_PERMISSION_REQUEST_CODE = 123

@Composable
fun SelectAddressContent(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val fusedLocationProviderClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val currentLocation = remember { mutableStateOf<Location?>(null) }

    val cameraPositionState = rememberCameraPositionState()

    val locationPermission = Manifest.permission.ACCESS_FINE_LOCATION
    val permissionGranted = ActivityCompat.checkSelfPermission(context, locationPermission) == PackageManager.PERMISSION_GRANTED

    LaunchedEffect(permissionGranted) {
        if (permissionGranted) {
            try {
                val location = getLastLocation(context, fusedLocationProviderClient)
                currentLocation.value = location
                location?.let {
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

    LaunchedEffect(currentLocation.value) {
        currentLocation.value?.let { location ->
            cameraPositionState.position = CameraPosition.fromLatLngZoom(
                LatLng(location.latitude, location.longitude),
                18f
            )
        }
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = "marker",
        )
    }

}