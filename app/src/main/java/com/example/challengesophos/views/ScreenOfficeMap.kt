package com.example.challengesophos.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.challengesophos.view_model.LoginViewModel
import com.google.android.gms.maps.model.LatLng


import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker

@Composable
fun ScreenOfficeMap(loginViewModel: LoginViewModel, navigationController: NavHostController) {
    val marker = LatLng(28.270833, -16.63916)
    val properties by remember { mutableStateOf(MapProperties(mapType = MapType.HYBRID)) }
    GoogleMap(modifier = Modifier.fillMaxSize(), properties = properties) {
        Marker(position = marker)
    }
}