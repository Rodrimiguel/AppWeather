package com.example.AppWeather.repository.modelos

import kotlinx.serialization.Serializable

@Serializable
class Ciudad(
    val name: String,
    val lat: Double,
    val lon: Double,
    val state: String,
)