package com.example.semestr.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: Name,
    val capital: List<String>?,
    val region: String,
    val population: Long,
    val flags: Flags
) : Parcelable

@Parcelize
data class Name(
    val common: String
) : Parcelable

@Parcelize
data class Flags(
    val png: String
) : Parcelable