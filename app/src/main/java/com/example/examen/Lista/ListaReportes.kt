package com.example.examen.Lista

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.examen.Navigation.Rutas
import com.example.examen.R

@Composable
fun ListaReportes(navController: NavController){
    Text(
        text = "Mis reportes",
        modifier = Modifier.fillMaxSize().padding(10.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp,60.dp,10.dp,0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        for (i in 1..10) {
            item {
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(
                            border = BorderStroke(2.dp, Color.LightGray)
                        )
                ) {itemReport(i, navController)}
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {navController.navigate(Rutas.Editar.route)},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = "añadir"
            )
        }
    }
}

@Composable
fun itemReport (i:Int, navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    navController.navigate(Rutas.ScreenDetail.route)
                }
        ) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(R.drawable.ic_baseline_report_24),
                    contentDescription = "Image description",
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                        .size(100.dp)
                )
                Column {
                    Text(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(0.dp, 10.dp),
                        text = "Reporte: $i"
                    )
                    val t1 = "Descripciónszlknzflksndfoljawssndfl lsdfnmaiksndfq fdwpofjwoainfonwasddlofnasolñdnfasldofn"
                    val t2 = "Ddwpofjwoainfonwasddlofnasolñdnfasldofn"
                    var t3 = ""
                    if (i%2 ==0){
                        t3 = t2
                    }else{
                        t3 = t1
                    }
                    Text(
                        modifier = Modifier
                            .width(150.dp)
                            .padding(0.dp, 10.dp),
                        text = t3
                    )
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Rutas.Editar.route)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit_24),
                    contentDescription = "editar",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp)
                )
            }
            IconButton(
                onClick = { navController.navigate(Rutas.Dialog.route)}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete_24),
                    contentDescription = "borrar",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(45.dp)
                )
            }
        }
    }
}
