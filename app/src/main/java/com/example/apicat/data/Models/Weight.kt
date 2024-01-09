package com.example.catapi.Models


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weight(
    @Json(name = "imperial")
    val imperial: String?, // 7  -  10
    @Json(name = "metric")
    val metric: String? // 3 - 5
) : Parcelable