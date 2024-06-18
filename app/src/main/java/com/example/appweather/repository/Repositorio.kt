package com.example.appweather.repository

import com.example.AppWeather.repository.modelos.Ciudad
import com.example.AppWeather.repository.modelos.Clima2

interface Repositorio {

    suspend fun buscarCiudad(ciudad: String): List<Ciudad>

    suspend fun traerClima(ciudad: Ciudad): Clima2

    suspend fun traerPronostico(Ciudad: Ciudad): List<Clima2>


}