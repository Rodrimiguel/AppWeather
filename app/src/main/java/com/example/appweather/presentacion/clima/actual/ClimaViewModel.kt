package com.example.appweather.presentacion.clima.actual

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.AppWeather.repository.modelos.Ciudad
import com.example.appweather.repository.Repositorio
import com.example.appweather.repository.RepositorioApi
import kotlinx.coroutines.launch

class ClimaViewModel(
    val repositorio: Repositorio
) : ViewModel() {

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repositorio = RepositorioApi()
                ClimaViewModel(repositorio)
            }
        }
    }

    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)

    fun ejecutar(intencion: ClimaIntencion) { // viem model
        when (intencion) {
            ClimaIntencion.BorrarTodo -> borrarTodo()
            ClimaIntencion.MostrarCaba -> mostrarCaba()
            ClimaIntencion.MostrarCordoba -> mostrarCordoba()
            ClimaIntencion.MostrarError -> mostrarError()
        }
    }

    private fun mostrarError() {
        uiState = ClimaEstado.Error("Error, Consulta con el ADMINISTRADOR")
    }

    private fun borrarTodo() {
        uiState = ClimaEstado.Vacio
    }

    private fun mostrarCaba() {

    }

    private fun mostrarCordoba() {
        ClimaEstado.Cargando
        viewModelScope.launch {
            val cordoba = Ciudad(name = "Cordoba", lat = -31.4135, lon = -64.18105, state = "Ar")
            try {
                val clima = repositorio.traerClima(cordoba)
                ClimaEstado.Exitoso(
                    ciudad = clima.name,
                    temperatura = 10.0,
                    descripcion = "-|-",
                    st = 10.2
                )
            } catch (exeption: Exception) {
                ClimaEstado.Error("-- Bug --")
            }
        }
    }
}




