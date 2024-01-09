package com.example.apicat.data.Models


import com.squareup.moshi.Json

data class respuesta_delete(
    @Json(name = "message")
    val message: String? // SUCCESS
)