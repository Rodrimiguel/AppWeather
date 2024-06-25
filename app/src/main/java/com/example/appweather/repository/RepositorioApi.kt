package com.example.appweather.repository


import com.example.appweather.repository.modelos.Ciudad
import com.example.appweather.repository.modelos.Clima
import com.example.appweather.repository.modelos.ForecastDTO
import com.example.appweather.repository.modelos.ListForecast
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositorioApi : Repositorio {

    private val apikey = "95e93e4f7a36fc511148468d1774792d"

    private val cliente = HttpClient() {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true
            })
        }
    }


    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val respuesta = cliente.get("https://api.openweathermap.org/geo/1.0/direct") {
            parameter("q", ciudad)
            parameter("limit", 100)
            parameter("appid", apikey)
        }
        if (respuesta.status == HttpStatusCode.OK) {
            val ciudades = respuesta.body<List<Ciudad>>()
            return ciudades
        } else {
            throw Exception()
        }
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        val respuesta = cliente.get("https://api.openweathermap.org/data/2.5/weather") {
            parameter("base", 00.00)
            parameter("lon", 00.00)
            parameter("units", "metric")
            parameter("appid", apikey)
        }
        if (respuesta.status == HttpStatusCode.OK) {
            val clima = respuesta.body<Clima>()
            return clima
        } else {
            throw Exception()
        }
    }

    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        val respuesta = cliente.get("https://api.openweathermap.org/v1/forecast") {
            // ?q=paris&appid=8e0af9a65e0f0b0663509216ea77440d
            parameter("q", nombre)
            parameter("units","metric")
            parameter("appid",apikey)

        }
        if (respuesta.status == HttpStatusCode.OK) {
            val forecast = respuesta.body<ForecastDTO>()
            return forecast.list
        } else {
            throw Exception()
        }
    }
}