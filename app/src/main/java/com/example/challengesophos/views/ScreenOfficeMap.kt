package com.example.challengesophos.views


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.challengesophos.model.OfficeItemResponse
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker

private var officeList: MutableList<OfficeItemResponse> = mutableListOf()


@Composable
fun ScreenOfficeMap() {
    //val properties by remember { mutableStateOf(MapProperties(mapType = MapType.HYBRID)) }
    GoogleMap(modifier = Modifier.fillMaxSize()) {
        Marker(position =LatLng(4.91667, -73.6667))
    }
}

@Composable
fun ScreenOfficeMap1(){
    GoogleMap(modifier = Modifier.fillMaxSize()){
        for (office in officeList)
            Marker(position = LatLng(office.Latitud.toDouble(), office.Longitud.toDouble()))
    }
}
/*@Composable
fun ScreenOfficeMap() {
    for (cities in officeList) {
        val marker = MarkerOptions()
            .position(LatLng(cities.Latitud.toDouble(), cities.Longitud.toDouble()))
            .title(cities.Nombre)
        GoogleMap(modifier = Modifier.fillMaxSize()) {
            Marker( marker.position)
        }
    }*/




