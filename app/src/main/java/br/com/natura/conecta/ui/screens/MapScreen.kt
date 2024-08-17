package br.com.natura.conecta.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.app.ActivityCompat
import br.com.natura.conecta.R
import br.com.natura.conecta.extensions.BitMapHelper
import br.com.natura.conecta.model.enums.OrderType
import br.com.natura.conecta.model.PickUpPoint
import br.com.natura.conecta.sampledata.getSurroundingPoints
import br.com.natura.conecta.sampledata.samplePickUpPoints
import br.com.natura.conecta.ui.components.map.PickUpPointCard
import br.com.natura.conecta.ui.components.widgets.SearchTextField
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    sheetState: SheetState,
    onMarkerClick: () -> Unit = {},
    onNavigateToOrderList: (OrderType) -> Unit = {}
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val fusedLocationProviderClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var lastKnownLocation by remember { mutableStateOf<Location?>(null) }
    var currentLocation by remember { mutableStateOf(LatLng(0.0, 0.0)) }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
    }
    val surroundingPoints = remember(currentLocation) {
        getSurroundingPoints(currentLocation)
    }
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    var selectedPoint by remember { mutableStateOf<PickUpPoint?>(samplePickUpPoints.first()) }
    var isCardExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            return@LaunchedEffect
        }

        fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                lastKnownLocation = task.result
                lastKnownLocation?.let {
                    currentLocation = LatLng(it.latitude, it.longitude)
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
                }
            }
        }
    }

    LaunchedEffect(sheetState.currentValue) {
        snapshotFlow { sheetState.currentValue }.collect {
            if (it == SheetValue.PartiallyExpanded) isCardExpanded = false
        }
    }

    BackHandler {
        scope.launch {
            sheetState.hide()
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            PickUpPointCard(
                pickUpPoint = selectedPoint!!,
                isExpanded = isCardExpanded,
                onListOrders = {
                    isCardExpanded = !isCardExpanded
                },
                onNavigateToOrderList = {
                    onNavigateToOrderList(it)
                },
                modifier = Modifier.navigationBarsPadding()
            )
        },
        sheetPeekHeight = 0.dp,
        sheetContainerColor = Color.White,
        sheetShadowElevation = 30.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            var text by remember { mutableStateOf("") }
            SearchTextField(
                searchText = text,
                onSearchChange = { text = it },
                modifier = Modifier
                    .zIndex(2f)
                    .align(Alignment.TopCenter)
                    .padding(top = 10.dp)
                    .fillMaxWidth(0.90f)
                    .statusBarsPadding(),
                shadow = true
            )
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(
                    mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.style),
                    isMyLocationEnabled = true
                ),
                uiSettings = MapUiSettings(
                    compassEnabled = false,
                    zoomControlsEnabled = false,
                    myLocationButtonEnabled = false
                )
            ) {
                surroundingPoints.forEach { pickUpPoint ->
                    Marker(
                        position = pickUpPoint.position,
                        title = pickUpPoint.name,
                        snippet = pickUpPoint.evaluation,
                        icon = BitMapHelper.imageToBitmap(context, pickUpPoint.icon, 100, 160),
                        onClick = {
                            val newPosition = LatLng(it.position.latitude - 0.005, it.position.longitude)
                            scope.launch {
                                delay(300)
                                cameraPositionState.animate(
                                    update = CameraUpdateFactory.newCameraPosition(
                                        CameraPosition(newPosition, 16f, 0f, 0f)
                                    )
                                )
                            }
                            selectedPoint = pickUpPoint
                            onMarkerClick()
                            true
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MapScreenPreview() {
    MapScreen(
        rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false
        )
    )
}