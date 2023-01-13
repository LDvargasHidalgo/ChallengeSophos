package com.example.challengesophos.model

data class MapOfficeResponse (
    var Items : List<OfficeItemResponse>,
    var Count : Int,
    var ScannedCount: Int
    )