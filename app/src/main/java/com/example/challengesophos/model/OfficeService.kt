package com.example.challengesophos.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface OfficeService {
    @GET("RS_Oficinas")
    suspend fun getOffice(): Response<MapOfficeResponse>

}