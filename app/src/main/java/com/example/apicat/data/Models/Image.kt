package com.example.apicat.data.Models


import com.squareup.moshi.Json

data class Image(
    @Json(name = "id")
    val id: String?, // JFPROfGtQ
    @Json(name = "url")
    val url: String? // https://cdn2.thecatapi.com/images/JFPROfGtQ.jpg
)