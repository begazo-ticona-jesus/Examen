package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.examen.Lista.Editar
import com.example.examen.Lista.ListaReportes
import com.example.examen.Navigation.Rutas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            //Wallpaper()
            //LoginUser()
            NavHost(
                navController = navController,
                startDestination = Rutas.ListaReportes.route
            ){
                composable(Rutas.ListaReportes.route){
                    ListaReportes(navController = navController)
                }
                composable(Rutas.Editar.route){
                    Editar(navController = navController)
                }
            }
        }
    }
}
