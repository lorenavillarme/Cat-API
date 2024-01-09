package com.example.apicat.data.Models


import com.squareup.moshi.Json

data class respuesta_post(
     @field:Json(name = "country_code")
    val countryCode: String?, // ES
     @field:Json(name = "id")
    val id: Int?, // 1031117
     @field:Json(name = "image_id")
    val imageId: String?, // ol
     @field:Json(name = "message")
    val message: String?, // SUCCESS
     @field:Json(name = "sub_id")
    val subId: String?, // my-user-1234
     @field:Json(name = "value")
    val value: Int? // 1
)