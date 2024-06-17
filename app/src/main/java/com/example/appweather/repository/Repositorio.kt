package com.istea.AppWeather.repository

import com.istea.AppWeather.repository.modelos.Ciudad
import com.istea.AppWeather.repository.modelos.Clima2

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): List<Ciudad>
    suspend fun traerClima(ciudad: Ciudad) : Clima2
    suspend fun traerPronostico(ciudad: Ciudad) : List<Clima2>
}