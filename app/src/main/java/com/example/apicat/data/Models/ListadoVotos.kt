package com.example.apicat.data.Models


import com.squareup.moshi.Json

data class ListadoVotos(
    @Json(name = "country_code")
    val countryCode: String?, // ES
    @Json(name = "created_at")
    val createdAt: String?, // 2023-05-16T12:07:44.000Z
    @Json(name = "id")
    val id: Int?, // 1031137
    @Json(name = "image")
    val image: Image?,
    @Json(name = "image_id")
    val imageId: String?, // JFPROfGtQ
    @Json(name = "sub_id")
    val subId: String?, // asds
    @Json(name = "value")
    val value: Int? // 1
)