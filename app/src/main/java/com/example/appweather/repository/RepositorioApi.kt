package com.example.appweather.repository

import com.example.AppWeather.repository.modelos.Ciudad
import com.example.AppWeather.repository.modelos.Clima2


class RepositorioApi : Repositorio{

    private val cliente = HttpCliente()


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
