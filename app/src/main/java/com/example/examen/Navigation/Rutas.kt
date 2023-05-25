package com.example.examen.Navigation

sealed class Rutas(val route: String) {
    object ListaReportes : Rutas("lista reportes")
    object Editar : Rutas("editar")
    object Dialog : Rutas("dialog")
    object ScreenDetail : Rutas("detalle")
}