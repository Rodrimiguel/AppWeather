package com.example.appweather.repository

import com.example.AppWeather.repository.modelos.Ciudad
import com.example.AppWeather.repository.modelos.Clima2
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositorioApi : Repositorio{

    private val apiKey = "dfa1e508561765575ee4f6856ef4b3ea"

    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        TODO("Not yet implemented")
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima2 {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(Ciudad: Ciudad): List<Clima2> {
        TODO("Not yet implemented")
    }

}





