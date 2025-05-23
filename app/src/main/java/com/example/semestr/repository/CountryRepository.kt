package com.example.semestr.repository

import com.example.semestr.model.Country
import com.example.semestr.network.ApiService
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountries(): List<Country> = apiService.getAllCountries()
}