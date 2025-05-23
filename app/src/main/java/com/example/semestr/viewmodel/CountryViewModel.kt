package com.example.semestr.viewmodel

import androidx.lifecycle.*
import com.example.semestr.model.Country
import com.example.semestr.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val repository: CountryRepository
) : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchCountries() {
        viewModelScope.launch {
            try {
                _countries.value = repository.getCountries()
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }
}