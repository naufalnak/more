package com.makaraya.more.screen.peta

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.makaraya.more.ui.theme.MORETheme
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PetaScreen() {
    val jakarta = LatLng(-6.2088, 106.8456)  // Koordinat Jakarta
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(jakarta, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = jakarta),
            title = "Jakarta",
            snippet = "Marker in Monas"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PetaScreenPrev() {
    MORETheme {
        PetaScreen()
    }
}