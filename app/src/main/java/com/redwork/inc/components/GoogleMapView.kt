package com.redwork.inc.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    content: @Composable () -> Unit = {},
    state: MarkerState
) {

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        onMapLoaded = onMapLoaded
    ) {
        Marker(
            state = state,
            title = "Veracruz"
        )
        content()
    }

}