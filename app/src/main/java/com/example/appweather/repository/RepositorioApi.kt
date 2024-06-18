package com.istea.AppWeather.repository

import com.istea.AppWeather.repository.modelos.Ciudad
import com.istea.AppWeather.repository.modelos.Clima2

class RepositorioApi : Repositorio{
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        TODO("Not yet implemented")
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima2 {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima2> {
        TODO("Not yet implemented")
    }

}