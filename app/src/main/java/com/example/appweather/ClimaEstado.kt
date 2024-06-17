package com.example.appweather

sealed class ClimaEstado {
        data class Exitoso (
            val ciudad: String = "",
            val temperatura: Double = 0.0,
            val descripcion: String= "",
            val st :Double = 0.0,
        ) : ClimaEstado ()






}