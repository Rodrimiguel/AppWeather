package com.example.appweather.presentacion

sealed class ClimaIntencion {
    object BorrarTodo: ClimaIntencion()
    object MostrarCordoba: ClimaIntencion()
    object MostrarCaba: ClimaIntencion()
    object MostrarError: ClimaIntencion()
}
