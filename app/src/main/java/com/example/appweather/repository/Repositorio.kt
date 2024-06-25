package com.example.appweather.repository

import com.example.appweather.repository.modelos.Ciudad
import com.example.appweather.repository.modelos.Clima
import com.example.appweather.repository.modelos.ListForecast

interface Repositorio {

    suspend fun buscarCiudad(ciudad: String): List<Ciudad>

    suspend fun traerClima(lat: Float, lon: Float) : Clima

    suspend fun traerPronostico(nombre: String) : List<ListForecast>


}