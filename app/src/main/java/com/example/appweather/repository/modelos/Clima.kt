package com.istea.AppWeather.repository.modelos


//import kotlinx.serialization.Serializable

class Clima(
    val temperatura: Int,
    val humedad: Float,
    val ciudad: String,
    val st: Int,
    val viento: Int,
    val latitud: Long,
    val longitud: Long,
    val estado: String
)

class Clima2(
    val base: String,
    val name: String,
)

class Coord(
    val lon: Double,
    val lat: Double,
)

class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)

class Main(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Long,
    val humidity: Long,
)

class Wind(
    val speed: Double,
    val deg: Long,
    val gust: Double,
)

class Clouds(
    val all: Long,
)

class Sys(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)