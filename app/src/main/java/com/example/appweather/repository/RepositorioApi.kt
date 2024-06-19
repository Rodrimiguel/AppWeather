package com.example.appweather.repository

import com.example.AppWeather.repository.modelos.Ciudad
import com.example.AppWeather.repository.modelos.Clima
import com.example.AppWeather.repository.modelos.Clima2
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositorioApi : Repositorio {

    private val apiKey = "dfa1e508561765575ee4f6856ef4b3ea"

    private val cliente = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val respuesta = cliente.get() {
            parameter("lat", 44.34)
            parameter("lon", 10.99)
            parameter("appid", apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK) {
            val ciudades = respuesta.body<List<Ciudad>>()
            return ciudades
        } else {
            throw Exception()
        }
    }
    override suspend fun traerClima(ciudad: Ciudad): Clima {
        val respuesta = cliente.get(){
            parameter("lat", 0.0)
            parameter("lon", 0.0)
            parameter("units","metric")
            parameter("appid",apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val clima = respuesta.body<Clima>()
            return clima
        }else{
            throw Exception()
        }
    }

    override suspend fun traerPronostico(lat: Float, lon: Float): List<Clima2> {
        TODO("Not yet implemented")
    }

}





