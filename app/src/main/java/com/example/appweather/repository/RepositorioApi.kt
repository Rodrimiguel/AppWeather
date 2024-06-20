package com.example.appweather.repository

import com.example.AppWeather.repository.modelos.Ciudad
import com.example.AppWeather.repository.modelos.Clima
import com.example.appweather.repository.modelos.ListForecast
import com.example.AppWeather.repository.modelos.ForecastDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositorioApi : Repositorio {

        private val apikey = ""

        private val cliente = HttpClient(){
            install(ContentNegotiation){
                json(Json { ignoreUnknownKeys = true })
            }
        }

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val respuesta = cliente.get() {
            parameter("q", ciudad)
            parameter("limit", 100)
            parameter("appid", apikey)
        }
        if (respuesta.status == HttpStatusCode.OK) {
            val ciudades = respuesta.body<List<Ciudad>>()
            return ciudades
        }else{
            throw Exception ()
        }
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima {
        val respuesta = cliente.get(){
            parameter("base", 00.00)
            parameter("lon", 00.00)
            parameter("units", "metric")
            parameter("appid", apikey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val clima = respuesta.body<Clima>()
            return clima
        }else {
            throw Exception()
        }
    }
    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        val respuesta = cliente.get(""){
            parameter("q",nombre)
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val forecast = respuesta.body<ForecastDTO>()
            return forecast.list
        }else{
            throw Exception()
        }
    }
}