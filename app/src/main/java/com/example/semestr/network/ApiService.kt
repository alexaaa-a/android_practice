package com.example.semestr.network

import com.example.semestr.model.Country
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    suspend fun getAllCountries(): List<Country>
}
