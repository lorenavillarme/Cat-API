package com.example.apicat.data.Models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Voto(
    @field:Json(name = "image_id")
    val imageId: String,
    @field:Json(name = "sub_id")
    val subId: String,
    @field:Json(name = "value")
    val value: Int
) : Parcelable