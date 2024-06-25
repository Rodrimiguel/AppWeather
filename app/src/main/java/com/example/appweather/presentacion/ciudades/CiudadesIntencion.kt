package com.example.appweather.presentacion.ciudades

import com.example.appweather.repository.modelos.Ciudad

sealed class CiudadesIntencion {
    data class Buscar (val nombre:String) : CiudadesIntencion()
    data class Seleccionar(val ciudad: Ciudad) : CiudadesIntencion()
}