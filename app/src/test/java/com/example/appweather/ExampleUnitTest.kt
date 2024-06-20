package com.example.appweather

import com.example.appweather.presentacion.ciudades.CiudadesEstado
import com.example.appweather.presentacion.ciudades.CiudadesIntencion
import com.example.appweather.presentacion.ciudades.CiudadesViewModel
import com.example.appweather.presentacion.ciudades.CiudadesViewModelFactory
import com.example.appweather.repository.RepositorioMock
import com.example.appweather.repository.RepositorioMockError
import com.example.appweather.router.MockRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class ExampleUnitTest {

    //Thread para simular la UI
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    //Dependencias mock
    val repositorio = RepositorioMock()
    val router = MockRouter()

    val repositorioError = RepositorioMock()

    //Armo ViewModel
    val factory = CiudadesViewModelFactory(repositorio,router)
    val viewModel = factory.create(CiudadesViewModel::class.java)

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun ciudadesViewModel_buscar_cor()  = runTest(timeout = 3.seconds) {
        //Creo Valor esperado
        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.cordoba))

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("cor"))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }

    @Test
    fun ciudadesViewModel_buscar_plata()  = runTest(timeout = 3.seconds) {
        //Creo Valor esperado
        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.laPlata))

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("plata"))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }

    @Test
    fun ciudadesViewModel_buscar_vacio()  = runTest(timeout = 3.seconds) {
        //Creo Valor esperado
        val estadoEsperado = CiudadesEstado.Vacio

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("jojo"))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }

    @Test
    fun ciudadesViewModel_buscar_error()  = runTest(timeout = 3.seconds) {

        val repositorioError = RepositorioMockError()

        //Armo ViewModel
        val fa = CiudadesViewModelFactory(repositorioError,router)
        val vm = fa.create(CiudadesViewModel::class.java)

        //Creo Valor esperado
        val estadoEsperado = CiudadesEstado.Error("error desconocido")

        launch(Dispatchers.Main) {
            vm.ejecutar(intencion = CiudadesIntencion.Buscar("jojo"))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, vm.uiState)
        }
    }

    @Test
    fun Newtest(){
        assertEquals(4, 2+2)
    }
}