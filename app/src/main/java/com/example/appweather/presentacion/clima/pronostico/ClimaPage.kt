package com.example.appweather.presentacion.clima.pronostico

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appweather.presentacion.clima.actual.ClimaView
import com.example.appweather.presentacion.clima.actual.ClimaViewModel

@Composable
fun MainPage() {
    val viewModel: ClimaViewModel = viewModel(factory = ClimaViewModel.factory)
    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}

